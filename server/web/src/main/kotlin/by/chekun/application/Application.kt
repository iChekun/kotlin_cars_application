package  by.chekun.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["by.chekun"])
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}