package tododo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tododo.TodoItem;

@Controller
public class MainController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("/")
	public String welcomeController(Model model) {
		model.addAttribute("todoItems", todoRepository.findAll());
		return "basepage";
	}
	
	@GetMapping("/add")
	public String addTodoItem(@RequestParam String contents, Model model) {
		TodoItem item = new TodoItem();
		item.setContents(contents);
		todoRepository.save(item);
		model.addAttribute("todoItems", todoRepository.findAll());
		return "basepage";
	}
	
	@GetMapping("/delete")
	public String deleteTodoitem(@RequestParam Integer id, Model model) {
		todoRepository.deleteById(id);
		model.addAttribute("todoItems", todoRepository.findAll());
		return "basepage";
	}

}
