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

object Strategy {

    fun calculate(map: Map<Action, Float>): Map<Action, Float> {

        // Create an immutable copy of the input map
        val regret: Map<Action, Float> = map.toMap()

        // Sum current values for all actions
        val valueSum = map.values.sum()

        // If the sum of values is > 0 then use the calculated value, otherwise
        // initialize the strategy to an equal chance per action
        return if (valueSum > 0) {

            map.mapValues { it.value / valueSum }

        } else {

            val count = map.size

            map.mapValues { 1F.div(count) }
        }
    }
}