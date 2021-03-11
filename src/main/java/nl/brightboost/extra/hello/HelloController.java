package nl.brightboost.extra.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value="post", method = RequestMethod.POST)
    public void addHello(@RequestBody Hello hello){
        helloService.addHello(hello);
        System.out.println(hello.getDescription() + "  id: " + hello.getId());
    }

    @RequestMapping(value="get", method = RequestMethod.GET)
    public List<Hello> getAll(){
        return helloService.getAllHellos();
    }

    @RequestMapping(value="get/{id}", method = RequestMethod.GET)
    public Hello getById(@PathVariable long id){
        return helloService.getById(id);
    }

    @RequestMapping(value="getone", method = RequestMethod.GET)
    public Hello getByIdParam(@RequestParam(value="id") long id){
        return helloService.getById(id);
    }

    @RequestMapping(value="sayhi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value="name") String name){
        return "hi " + name;
    }
}
