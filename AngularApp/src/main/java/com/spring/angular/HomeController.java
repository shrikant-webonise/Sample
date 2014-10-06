package com.spring.angular;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private static final String INCOMPLETE = "Incomplete";
	private static final String COMPLETED = "Completed";
	private static final String TODAY = "Today";
	List<toDo> list = new ArrayList<toDo>();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getData()
	{
		ModelAndView model = new ModelAndView("home");
		return model;	
	}
		
	@RequestMapping(value = "/tasks", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<toDo> getAllTasks()
	{
		logger.info("Getting tasks Method.");
		return list;		
	}
	
	@RequestMapping(value = "/addTask/{taskName}", method = RequestMethod.POST, produces="application/json")
	public  @ResponseBody List<toDo> getTasks(@PathVariable("taskName") String tasks) throws ParseException
	{
		logger.info("Value is : {}" , tasks);
		toDo task = new toDo();
		task.setTaskName(tasks);
		task.setStatus(INCOMPLETE);
		task.setCreatedOn(TODAY);
		list.add(task);
		return list;	
	}
	
	@RequestMapping(value = "/updateTask/{comb}", method = RequestMethod.POST, produces="application/json")
	public  @ResponseBody List<toDo> getUpdatedTasks(@PathVariable("comb") String tasks) throws ParseException
	{
		logger.info("Value is Updated : {}" , tasks);
		String [] parts = tasks.split(",");
		int part1 = Integer.parseInt(parts[0]);
		String part2 = parts[1];
		logger.info("Value is Updated : {}" , part1);
		logger.info("Value is Updated : {}" , part2);
		toDo task = new toDo();
		toDo dm = list.get(part1);
		logger.info("D M : {}" , dm);
		dm.setStatus(COMPLETED);
		dm.setCreatedOn(TODAY);
		dm.setTaskName(part2);
		return list;
	}
	
	@RequestMapping(value = "/deleteTask/{taskName}", method = RequestMethod.POST, produces="application/json")
	public  @ResponseBody List<toDo> getDeletedTasks(@PathVariable("taskName") String tasks) throws ParseException
	{
		logger.info("Value is Deleted : {}" , tasks);		
		if(list != null && !list.isEmpty())
		{
			for (toDo task : list)
			{
				if (task.getTaskName().equals(tasks))
				{
					list.remove(task);
				}
				
			}
		}
			
		return list;	
	}	
}	