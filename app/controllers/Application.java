package controllers;

import java.util.List;

import play.api.modules.spring.Spring;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import beans.GalaxyService;
import beans.World;

public class Application extends Controller {

	public static Result index() {
		GalaxyService galaxyService = Spring.getBeanOfType(GalaxyService.class);
		if (galaxyService == null)
			notFound("Unable to load galaxyService from the Spring Context.");

		if (galaxyService.getNumberOfWorlds() == 0) {
			galaxyService.makeSomeWorldsAndRelations();
		}

		List<World> allWorlds = galaxyService.getAllWorlds();
		World first = allWorlds.get(0);
		World last = allWorlds.get(allWorlds.size() - 1);
		List<World> pathFromFirstToLast = galaxyService.getWorldPath(first, last);
		return ok(index.render(allWorlds, pathFromFirstToLast));
	}
}