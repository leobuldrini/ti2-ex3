package maven.ex03leo;

import static spark.Spark.*;

public class HelloWord {

	public static void main(String[] args) {
		get("/hello", (request,response) -> "Hello World");
	}

}
