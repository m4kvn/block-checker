package com.m4kvn.blockchecker

import com.m4kvn.blockchecker.command.CheckCommand
import org.slf4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GamePreInitializationEvent
import org.spongepowered.api.event.game.state.GameStartingServerEvent
import org.spongepowered.api.plugin.Plugin
import javax.inject.Inject

@Plugin(
    id = "block-checker",
    name = "BlockChecker"
)
class Main {

    @Inject
    lateinit var logger: Logger

    @Listener
    fun onGamePreInitialization(event: GamePreInitializationEvent) {
        logger.debug("onGamePreInitialization(event=$event)")
    }

    @Listener
    fun onGameStartingServer(event: GameStartingServerEvent) {
        logger.debug("onGameStartingServer(event=$event)")
        CheckCommand.register(this)
    }
}