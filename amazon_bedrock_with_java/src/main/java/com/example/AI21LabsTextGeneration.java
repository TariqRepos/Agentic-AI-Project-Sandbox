package com.example;

import java.nio.charset.Charset;
import org.json.JSONObject;

import com.example.util.BedrockRequestBody;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;

/*
 * Code should parse prompt for the band name "Good Kid"
 */
public class AI21LabsTextGeneration {

    private static final String MODEL_ID = "ai21.j2-mid-v1";

    private static final String PROMPT = """
        Extract the band name from the contract:

        This Music Recording Agreement ("Agreement") is made effective as of the 13 day of December,
        2021 by and between Good Kid, a Toronto-based musical group (“Artist”) and Universal Music Group,
        a record label with license number 545345 (“Recording Label"). Artist and Recording Label may each
        be referred to in this Agreement individually as a "Party" and collectively as the "Parties."
        Work under this Agreement shall begin on March 15, 2022.
    """;

    public static void main(String... args) throws Exception {

        // Set up AWS Bedrock client to interact with FMs using credentials from profile
        try (BedrockRuntimeClient bedrockClient = BedrockRuntimeClient.builder()
            .region(Region.US_EAST_1)
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build()) {

            // Create body for Bedrock requests
            String bedrockBody = BedrockRequestBody.builder()
                .withModelId(MODEL_ID)
                .withPrompt(PROMPT)
                .build();

            // Create model specific request, using utlity class body
            InvokeModelRequest invokeModelRequest = InvokeModelRequest.builder()
                .modelId(MODEL_ID)
                .body(SdkBytes.fromString(bedrockBody, Charset.defaultCharset()))
                .build();

            // Invoke model and convert response to JSON
            InvokeModelResponse invokeModelResponse = bedrockClient.invokeModel(invokeModelRequest);
            JSONObject responseAsJson = new JSONObject(invokeModelResponse.body().asUtf8String());

            // Log response, remember that not all models have the same response format
            System.out.println("🤖 Response: ");
            System.out.println(responseAsJson
                .getJSONArray("completions")
                .getJSONObject(0)
                .getJSONObject("data")
                .getString("text"));
        }
    }
}