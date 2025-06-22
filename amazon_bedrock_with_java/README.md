# AWS Bedrock JAVA Projects

## Getting Started

- Setup JAVA in vscode using the guide: [Getting Started with Java in VS Code](https://code.visualstudio.com/docs/java/java-tutorial)
- JDK 21+
- Install [Maven](https://maven.apache.org/download.cgi#Installation) and add to system path
- Add these to your Maven `pom.xml`:

```xml
<dependency>
  <groupId>software.amazon.awssdk</groupId>
  <artifactId>bedrockruntime</artifactId>
  <version>2.x.x</version> <!-- Use the latest version -->
</dependency>
<dependency>
  <groupId>org.json</groupId>
  <artifactId>json</artifactId>
  <version>20240303</version>
</dependency>
```
- Access to Amazon Bedrock and foundation models
- AWS credentials configured via `~/.aws/credentials`


## AI21LabsTextGeneration
This Java program demonstrates how to use the **AI21 Labs J2 Mid v1 model** via **Amazon Bedrock** to extract a band name from a legal-style prompt. It highlights the use of a **synchronous (blocking) request** to a foundation model for text parsing and extraction.

---
### Resources
- https://youtu.be/Jj1-zb38Yfw?si=Jv1oeCZKVW33-7Oz
- https://youtu.be/Vv2J8N0-eHc?si=TJq21zLNFu6t3fO6

---
### 🚀 How It Works

1. A contract-style prompt containing the specified `"text"` to parse is defined in the code
2. An AWS Bedrock client is initialized using credentials from your local AWS profile
3. A request body is built specifying the model (`ai21.j2-mid-v1`) and the prompt
4. A synchronous (`blocking`) call is made to `invokeModel()` to send the request to the model
5. The response is returned as a JSON payload containing an array of completions
6. The program extracts the `"text"` field from the first completion and prints the result

---

### 📌 Features

- 🔎 **Named Entity Extraction**: Parses legal language to extract specific text (e.g., a band name).
- 🧠 **AI21 Labs Model Integration**: Uses `ai21.j2-mid-v1` via AWS Bedrock.
- 🔐 **Secure Auth**: Leverages AWS profile credentials for secure access.
- 📄 **Synchronous Invocation**: Uses a blocking call to retrieve and process results immediately.

---

## ClaudeContentGeneration
This Java application demonstrates how to use the **Anthropic Claude v2 model** via **Amazon Bedrock** to summarize a detailed prompt into a short, easy-to-understand paragraph. The interaction is performed with a **synchronous (blocking) request** to return the model's output.

---
### Inspiration
https://www.youtube.com/watch?v=Vv2J8N0-eHc&list=LL&index=10&t=58s

---
### 🚀 How It Works

1. A detailed prompt about generative AI is defined in the code
2. A Bedrock async client is initialized using your AWS profile
3. A request body with inference parameters (`temperature`, `max_tokens`, etc.) is built
3. A request body is built specifying the model (`anthropic.claude-v2`) and the prompt
4. A synchronous (`blocking`) call is made to `invokeModel()` to send the request to the model
6. When call completes, the summary is printed

---

### 📌 Features

- 📄 **Synchronous Invocation**: Uses a blocking call to retrieve and process results immediately.
- 🧠 **Anthropic Claude V2 Model Integration**: Uses `anthropic.claude-v2` via AWS Bedrock.
- 🧠 **Natural Language Summarization**: Converts a long, technical explanation into a simplified summary using Claude v2.
- 🔐 **Secure Auth**: Uses AWS profile credentials to authenticate securely with Amazon Bedrock.

---


## ClaudeChatWithStreaming
This Java application demonstrates how to use the **Anthropic Claude v2 model** via **Amazon Bedrock** to summarize a detailed prompt into a short, easy-to-understand paragraph. The interaction is performed **asynchronously**, and the model's output is streamed in real time.

---
### Inspiration
https://www.youtube.com/watch?v=Vv2J8N0-eHc&list=LL&index=10&t=58s

---
### 🚀 How It Works

1. A detailed prompt about generative AI is defined in the code
2. A Bedrock async client is initialized using your AWS profile
3. A request body with inference parameters (`temperature`, `max_tokens`, etc.) is built
4. The request is submitted using a virtual thread
5. As the Claude v2 model responds, output is streamed and printed chunk-by-chunk
6. When streaming completes, the main thread resumes and the program exits

---

### 📌 Features

- 🔄 **Async + Non-blocking**: Uses virtual threads and a `CountDownLatch` to handle async model responses.
- 📤 **Streaming Output**: Streams partial outputs (`chunks`) as they arrive, instead of waiting for a full response.
- 🧠 **Natural Language Summarization**: Converts a long, technical explanation into a simplified summary using Claude v2.
- 🔐 **Secure Auth**: Uses AWS profile credentials to authenticate securely with Amazon Bedrock.

---
