from strands import Agent
from strands.models.anthropic import AnthropicModel
from strands_tools import current_time, http_request, use_aws
from dotenv import load_dotenv
import os


# Load environment variables from .env
load_dotenv()
api_key = os.getenv("ANTHROPIC_API_KEY")

# Initialize Claude model with your API key
model = AnthropicModel(
    client_args={
        "api_key": api_key  # Replace with your key OR comment the model line in agent to use Bedrock default
    },
    model_id="claude-3-7-sonnet-20250219",  # Use Claude 
    max_tokens=1000
)
WEATHER_SYSTEM_PROMPT = """You are a weather assistant with HTTP capabilities. You can:
1. Make HTTP requests to the National Weather Service API
2. Process and display weather forecast data
3. Provide weather information for locations in the United States

When displaying responses:
- Format weather data in a human-readable way
- Highlight important information like temperature, precipitation, and alerts
- Handle errors appropriately
- Convert technical terms to user-friendly language

Always explain the weather conditions clearly and provide context for the forecast.
""" 

# Create agent using strands with the Claude 4 model
agent = Agent(
    model=model,
    tools=[
        current_time, # Allows the agent to retrieve the current time
        http_request, # Enables the agent to make HTTP GET/POST requests to external APIs
        use_aws       # Grants the agent access to interact with AWS services via boto3
    ],
    system_prompt=WEATHER_SYSTEM_PROMPT
)

# Use agent with the tools to answer ther related question
response = agent("1. what is the time in new york city? 2. What is the weather in new york city? 3. list the s3 buckets in my aws account")
print(response)









