package pl.mg6maciej.funthingsyoucandoinkotlin.animals

import java.util.*

class Person(val name: String) : RiddleLovingCreature {

    override fun askRiddle(someone: Person) {
        val riddle = thinkOfRiddle()
        someone.ask(riddle, this)
    }

    private fun thinkOfRiddle(): String {
        val riddleId = Random().nextInt(3)
        return riddles[riddleId]
    }

    private fun ask(riddle: String, asker: Person) {
        val answer = when (riddle) {
            riddles[0] -> "A human being."
            riddles[1] -> "The North Pole."
            else -> "I don't know..."
        }
        asker.answer(answer, this)
    }

    private fun answer(answer: String, person: Person) {
        if (answer.startsWith("I don't know")) {
            reactToWrongAnswer(person)
        }
    }

    override fun reactToWrongAnswer(from: Person) {
        print("Haha! It's wrong, ${from.name}.")
    }

    companion object {
        val riddles = listOf(
                "When I am young, I go on four legs, then I go on two legs, then I go on three legs, and then I die.",
                "Here there is no north, west, nor east, And weather fit for not man nor beast.",
                "What's in my pocket?")
    }
}
