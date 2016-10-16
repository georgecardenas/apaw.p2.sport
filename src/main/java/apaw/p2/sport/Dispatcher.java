package apaw.p2.sport;

import apaw.p2.sport.api.SportResource;
import apaw.p2.sport.api.UserResource;
import apaw.p2.sport.exceptions.InvalidRequestException;
import apaw.p2.sport.http.HttpRequest;
import apaw.p2.sport.http.HttpResponse;
import apaw.p2.sport.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
	    // **/users
		if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
		} else if("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])){
		    String sport = request.getParams().get("sport");
		    response.setBody(userResource.getUserListbySport(sport).toString());
		} else if ("sports".equals(request.getPath())){
		    response.setBody(sportResource.sportList().toString());
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST users body="nick:email"
		case "users":
			String nick = request.getBody().split(":")[0];
			String email = request.getBody().split(":")[1];
			try {
				userResource.createUser(nick, email);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		// POST users body="name"
        case "sports":
            String name = request.getBody();
            try {
                sportResource.createSport(name);
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                responseError(response, e);
            }
            break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
	    
	    // **/users/{nick}/sports
        if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
            String nick = request.paths()[1];
            String sport = request.getBody();
            try {
                userResource.addSportToUser(nick, sport);
                response.setStatus(HttpStatus.OK);
            } catch (Exception e) {
                responseError(response, e);
            }
        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
        }
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
