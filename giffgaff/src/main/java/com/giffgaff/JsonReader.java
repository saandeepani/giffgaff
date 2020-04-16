package com.giffgaff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.giffgaff.jackson.model.Products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonReader {
	
	static Logger logger = LoggerFactory.getLogger(JsonReader.class);

	public static void main(String[] args) {
		
		//Buffer Reader to read values from console Note: Scanner is much better performance for single read
		BufferedReader br = null;
		Reader input = new InputStreamReader(System.in);
		br = new BufferedReader(input);
		String searchProduct = null;

		try {
			do {
				System.out.println("What is the product name?" + searchProduct);
				searchProduct = br.readLine();
				//new JsonReader Object to call searchProduct
				JsonReader jsonReader = new JsonReader();
				String resultProduct = jsonReader.searchProduct(searchProduct);

				if (null == resultProduct) {
					System.out.println("Sorry, that product was not found in our inventory.");
				}
			} while (!searchProduct.equalsIgnoreCase("exit"));

		} catch (IOException e) {
			logger.error("Problem with IO"); // make sure not print to much info be more Generic.
		}

	}

	public String searchProduct(String searchProduct) {

		String productFoundJson = null;

		try {
			FileReader fr = new FileReader("/home/sandeep/Documents/products.json");
			JsonObject jsonObj = (JsonObject) Json.parse(fr);
			JsonArray jsonArray = (JsonArray) jsonObj.get("products");
			String jsonArayString = jsonArray.toString();
			
			ObjectMapper mapper = new ObjectMapper();
			Products[] pp = mapper.readValue(jsonArayString, Products[].class);

			for (Products p : pp) {
				if (p.getName().equalsIgnoreCase(searchProduct)) {
					
					productFoundJson = mapper.writeValueAsString(p);
					System.out.println(productFoundJson);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("Couldn't able to File to read");
		} catch (IOException e) {
			logger.error("Problem with IO at File reader");
		}

		
		return productFoundJson;

	}
}
