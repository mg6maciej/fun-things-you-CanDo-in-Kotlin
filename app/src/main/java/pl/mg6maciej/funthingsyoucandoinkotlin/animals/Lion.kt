package pl.mg6maciej.funthingsyoucandoinkotlin.animals

class Lion : HumanEatingCreature {

    override fun eat(person: Person) {
        print("nom-nom-nom, yummy $person")
    }
}
