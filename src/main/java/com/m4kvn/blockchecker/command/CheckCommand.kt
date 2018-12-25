package com.m4kvn.blockchecker.command

import org.koin.standalone.KoinComponent
import org.spongepowered.api.Sponge
import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.data.type.HandTypes
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.text.Text

class CheckCommand : CommandExecutor, KoinComponent {

    companion object {

        private fun newSpec() =
            CommandSpec.builder()
                .executor(CheckCommand())
                .build()

        fun register(plugin: Any) {
            Sponge.getCommandManager()
                .register(plugin, newSpec(), "check")
        }
    }

    override fun execute(src: CommandSource, args: CommandContext): CommandResult {
        if (src !is Player) return CommandResult.empty()

        src.getItemInHand(HandTypes.MAIN_HAND).ifPresent { itemStack ->
            src.sendMessage(Text.builder("$itemStack").build())
            return@ifPresent
        }
        return CommandResult.success()
    }
}