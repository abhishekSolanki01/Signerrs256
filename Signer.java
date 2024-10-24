package com.sspl.sample.filter;

import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.jws.AlgorithmIdentifiers;

public class Signer {

    public static void main(String[] args) {
        // You can test the Sign method here
        String payload = "your-payload-here"; // Replace with your actual payload
        String privateKey = "your-private-key-here"; // Replace with your actual private key
        
        String signedResult = Sign(payload, privateKey);
        System.out.println("Signed Result: " + signedResult);
    }

    public static String Sign(String payload, String privateKey) { 
        try {
            // Create RsaJsonWebKey from private key (replace getPrivateKey with actual method to load)
            RsaJsonWebKey rsaJsonWebKey = getPrivateKey(privateKey); 
            JsonWebSignature jws = new JsonWebSignature(); 
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
            jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
            jws.getHeaders().setObjectHeaderValue(HeaderParameterNames.BASE64URL_ENCODE_PAYLOAD, false);
            jws.setPayload(payload); 
            jws.setKey(rsaJsonWebKey.getPrivateKey());
            String digitalSignature = jws.getDetachedContentCompactSerialization();
            return digitalSignature;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Replace this method with actual implementation to load private key
    private static RsaJsonWebKey getPrivateKey(String privateKey) {
        // Load and return the RsaJsonWebKey object from the private key
        return null; // Placeholder
    }
}
