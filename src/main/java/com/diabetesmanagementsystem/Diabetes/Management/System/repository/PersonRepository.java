package com.diabetesmanagementsystem.Diabetes.Management.System.repository;

        import com.diabetesmanagementsystem.Diabetes.Management.System.model.Person;
        import com.fasterxml.jackson.core.type.TypeReference;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.context.annotation.Configuration;

        import java.io.File;
        import java.io.IOException;
        import java.util.List;
        import java.util.Optional;

        @Configuration
        @Slf4j
        public class PersonRepository {

            private final ObjectMapper objectMapper;
            private final List<Person> personList;

            public PersonRepository() throws IOException {
                this.objectMapper = new ObjectMapper();
                this.personList = healthData();
                log.info("Person list: {}", objectMapper.writeValueAsString(personList));
            }

            public List<Person> healthData() throws IOException {
                return objectMapper.readValue(
                        new File("src/main/resources/health_data_alberta.json"), new TypeReference<>() {
                        }
                );
            }

            public Person findByName(String name) {
                Optional<Person> personOptional = personList.stream().filter(person -> person.getName().equals(name)).findFirst();
                return personOptional.orElse(null);
            }
        }