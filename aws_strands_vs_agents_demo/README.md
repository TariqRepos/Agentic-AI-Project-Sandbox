# AWS Strands Weather Tool Demo
This project demonstrates a multi-tool AI agent built with the [Strands SDK](https://github.com/strands-ai/strands), powered by Anthropic's Claude 3 model. The agent can:

- 🌐 Fetch real-time weather data from external APIs
- ⏰ Report the current time
- ☁️ Interact with AWS services (like listing S3 buckets)

---

## Resources
- https://github.com/strands-ai/strands
- https://www.youtube.com/watch?v=dT89C2MuYj4&list=LL&index=9&t=31s


---

## Getting Started

1. Set up Python environment:
```bash
python -m venv venv
source venv/Scripts/activate  # Use venv/bin/activate on macOS/Linux
pip install -r requirements.txt
```

2. Add your environment variables:
```bash
ANTHROPIC_API_KEY=your-claude-api-key-here
AWS_ACCESS_KEY_ID=your-aws-access-key
AWS_SECRET_ACCESS_KEY=your-aws-secret
```

---

## How It Works
- Claude 3.7 Sonnet is initialized using your Anthropic API key.
- The Agent is created with a custom system_prompt tailored for U.S. weather.
- Tools like http_request and use_aws allow the agent to query weather APIs and list AWS S3 buckets.
- The final response is printed to the console.