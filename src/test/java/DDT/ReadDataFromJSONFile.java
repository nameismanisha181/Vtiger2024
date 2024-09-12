package DDT;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadDataFromJSONFile {
public static void main(String[] args) throws IOException {
	
	File fis=new File("./src/test/resources/data.json");
	
	ObjectMapper mapper= new ObjectMapper();
	JsonNode data = mapper.readTree(fis);
	
	String USERNAME = data.get("username").asText();
	System.out.println(USERNAME);
	
}
}
