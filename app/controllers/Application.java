package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import beans.GalaxyService;
import beans.World;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	GalaxyService galaxyService;

	public Result index() {

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