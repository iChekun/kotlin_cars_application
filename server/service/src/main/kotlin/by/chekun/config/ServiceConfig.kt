package by.chekun.config


import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration.AccessLevel.PRIVATE
import org.modelmapper.convention.MatchingStrategies
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ServiceConfig {

    @Bean
    fun modelMapper(): ModelMapper? {
        val mapper = ModelMapper()
        mapper.configuration
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setSkipNullEnabled(true).fieldAccessLevel = PRIVATE
        return mapper
    }

}