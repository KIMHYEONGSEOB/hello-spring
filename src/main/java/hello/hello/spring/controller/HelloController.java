package hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//정적 컨텐츠는 파일을 그대로 내려줌
//mvc와 템프릿엔진은 템플릿 엔진을 모델뷰 컨트롤러 방식으로 나눠서 뷰를 템플릿 엔진으로 html을
@Controller
public class HelloController {

    @GetMapping("/hello")
    public  String hello(Model model){
        model.addAttribute("da","김형섭");
        return "hello";
    }
    @GetMapping("hello-mvc")//@RequestParam은 viewresolver가 작동함
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); //mvc
        return "hello-template"; //html template에 리턴해줌
    }

    /*@ResponseBody는 return 값이 단순 문자면 stringconverter가 작동하고
    객체면 jasonconverter가 동작함*/
    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(@RequestParam("name") String name){
        return "hello"+name; //html body부분에 직접 넣음
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Person helloApi(@RequestParam("name") String name){
//        Hello hello = new Hello();
//        hello.setName(name);
//        return hello;
//

        Person person1;
        person1 = new Person();
        person1.name = name;
        person1.age = 30;
        person1.school = "한양대";

        return person1;
        // {"name" : "김똥개", "age" : 30 , "school", "한양대"}
    }

    static class Person {
        String name;
        int age;
        String school;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getSchool() {
            return school;
        }
    }
}
