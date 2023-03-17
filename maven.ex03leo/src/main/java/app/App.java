package app;

import static spark.Spark.*;

import service.GameService;

public class App {
	private static GameService gameService = new GameService();

	public static void main(String[] args) {
		port(8080);
		get("/hello", (request,response) -> "Hello World");
		post("/game", (request, response) -> gameService.add(request, response));
		get("/game/:id", (request, response) -> gameService.get(request, response));
	}

}
