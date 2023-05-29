package com.fynd.nitrozen.components.textfield

sealed interface MaxCharacterConfiguration{
    class Enabled(val maxChar : Int, val showMaxCharacter : Boolean) : MaxCharacterConfiguration
    object Disabled : MaxCharacterConfiguration
}