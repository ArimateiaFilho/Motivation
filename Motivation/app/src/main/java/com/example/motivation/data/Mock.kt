package com.example.motivation.data

import com.example.motivation.config.Constants
import kotlin.random.Random

class Phrase(val description: String, val categoryId: Int, val language: String)

class Mock {

    private val allInclusive = Constants.FILTER.ALL_INCLUSIVE
    private val happy = Constants.FILTER.HAPPY
    private val sunny = Constants.FILTER.SUNNY
    private val langEn = Constants.LANGUAGE.ENGLISH
    private val langPt = Constants.LANGUAGE.PORTUGUESE

    private val listPhrase = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy, langPt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy, langPt),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy, langPt),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy, langPt),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, langPt),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy, langPt),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, langPt),
        Phrase("Se você acredita, faz toda a diferença.", sunny, langPt),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny, langPt),
        Phrase("Not knowing it was impossible, he went there and did it.", happy, langEn),
        Phrase("You are not defeated when you lose, you are defeated when you give up!", happy, langEn),
        Phrase("When it's darker, we see more stars!", happy, langEn),
        Phrase("Insanity is always doing the same thing and expecting a different result.", happy, langEn),
        Phrase("Don't stop when you're tired, stop when you're done.", happy, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", happy, langEn),
        Phrase("The best way to predict the future is to invent it.", sunny, langEn),
        Phrase("You lose every chance you don't take.", sunny, langEn),
        Phrase("Failure is the spice that flavors success.", sunny, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", sunny, langEn),
        Phrase("If you don't know where you want to go, any way will do.", sunny, langEn),
        Phrase("If you believe, it makes all the difference.", sunny, langEn),
        Phrase("Risks must be taken, because the greatest danger is not risking anything!", sunny, langEn)
    )

    fun getPhrase(id: Int, language: String): String {
        val phrase = listPhrase.filter {
            (it.categoryId == id || id == allInclusive) && it.language == language
        }
        return phrase[Random.nextInt(phrase.size)].description
    }

}