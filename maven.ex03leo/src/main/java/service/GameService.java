package service;

import dao.DAO;
import model.Game;
import spark.Request;
import spark.Response;

public class GameService {
	
	private DAO dao;
	
	public GameService() {
		try {
			dao = new DAO();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Object add(Request request, Response response) {
		String nome = request.queryParams("nome");
		String dataLancamento = request.queryParams("dataLancamento");
		String genero = request.queryParams("genero");
		
		Game game = new Game(0, nome, dataLancamento, genero);
		dao.inserirGame(game);
		
		response.status(201);
		
		return game.getId();
	}
	
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));
		
		Game game = dao.getGame(id);
		
		response.header("Content-Type", "application/xml");
	    response.header("Content-Encoding", "UTF-8");
		
		return "<produto>\n" + 
				"\t<id>" + game.getId() + "</id>\n" +
				"\t<nome>" + game.getNome() + "</nome>\n" +
				"\t<genero>" + game.getGenero() + "</genero>\n" +
				"\t<dataL>" + game.getDataLancamento() + "</dataL>\n" +
				"</produto>\n";
		
	}
	

}
