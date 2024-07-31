package com.vssekorin.viridez.telegram

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.vssekorin.viridez.telegram.configuration.BotProperties
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ViridezBotRunner(private val botProperties: BotProperties) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val bot = bot {
            token = botProperties.token

            dispatch {
                text("ping") {
                    bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "pong")
                }
            }
        }
        bot.startPolling()
    }
}
