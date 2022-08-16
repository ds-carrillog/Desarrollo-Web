# Dependency injection
- Repasar DI
- DI con Anotaciones en Spring

# Dependencias
- spring-boot-starter-thymeleaf
- spring-boot-starter-web
- spring-boot-devtools

# Ejemplo sencillo `@Controller` + `@ResponseBody`
https://www.baeldung.com/spring-controller-vs-restcontroller
- `@Controller`
- `@ResponseBody`
- `@GetMapping`

# Configuración
https://www.baeldung.com/spring-componentscan-vs-enableautoconfiguration
- `@Configuration`
  - `@Bean`
- `@EnableAutoConfiguration`
  - `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet. https://spring.io/guides/gs/spring-boot/
    - https://www.baeldung.com/spring-dispatcherservlet
- `@ComponentScan`
- `@Autowired`

# Parámetros
- `@RequestParam`
  - https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400
- `@PathVariable`

# Simular base de datos


# Spring MVC
- MVC

# Thymeleaf
- Configuración
  - src/main/templates
  - src/main/static
- Plantillas
  - https://www.baeldung.com/thymeleaf-in-spring-mvc
  - Estructura
- Ejemplos
  - HelloWorldWithTemplates
    - ModelAndView
  - HelloWorldWithTemplatesIntl https://www.baeldung.com/java-resourcebundle
  - Redirection
  - Message expressions `#{...}`
    - https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#expression-basic-objects
  - VariableExpressions `${...}`
    - Variables simples
    - Iteración https://www.baeldung.com/thymeleaf-iteration
      - Variable `stat`
  - Selection Variable Expressions: `*{...}`
    - SelVarExp
  - Link URL Expressions: `@{...}`
    - person-list.html
    - https://www.thymeleaf.org/doc/articles/standardurlsyntax.html
  - Conditionals
    - person-list.html
  - Fragment Expressions: `~{...}`
    - Parameterizable fragments https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#parameterizable-fragment-signatures
  - Errors
    - `MyCustomErrorController`
    - `NotFoundException`