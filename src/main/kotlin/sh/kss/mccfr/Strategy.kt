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

    fun calculate(infoSet: InfoSet): InfoSet {

        // Create an immutable copy of the input strategy from the InfoSet
        val regret: Map<Action, Float> = infoSet.regret.toMap()

        // Sum current regret for all actions
        val regretSum = regret.values.sum();

        // If the sum of regret is > 0 then use the calculated value, otherwise
        // initialize the strategy to an equal chance per action
        return if (regretSum > 0) {

            infoSet.copy(strategy = regret.mapValues { it.value / regretSum })

        } else {

            val count = infoSet.regret.size

            infoSet.copy(strategy = regret.mapValues { 1F.div(count) })
        }
    }
}