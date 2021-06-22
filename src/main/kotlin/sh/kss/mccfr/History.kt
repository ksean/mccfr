/**
An implementation of the paper "Monte Carlo Sampling for Regret Minimization in Extensive Games"
https://mlanctot.info/files/papers/nips09mccfr.pdf
Copyright (C) 2021 Kennedy Software Solutions Inc.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package sh.kss.mccfr

interface History {

    // Is the game over
    fun isTerminal(): Boolean

    // How much utility did a given player have at the end of the game
    fun terminalUtility(player: Player): Float

    // Get the player for the current turn
    fun player(): Player

    // Get the information set for the current turn
    fun infoSet(): InfoSet

    // Get the winning player, return null if no winner or not terminal
    fun winner(): Player?

    // Perform an action for the current player's turn
    fun perform(action: Action): History

    // Check for the legality of an action this turn
    fun canPerform(action: Action): Boolean
}