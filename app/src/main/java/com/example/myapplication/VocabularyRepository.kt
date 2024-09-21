package com.example.myapplication

class VocabularyRepository {

    fun getList(): List<VocabularyModel> {
        return listOf(
            VocabularyModel("a position","a job or a title"),
            VocabularyModel("a candidate", "someone who is being considered for a job"),
            VocabularyModel("human resources (HR)","the department in a company that deals with hiring, training, and helping employees"),
            VocabularyModel("an application","a formal, written request for a job, usually a form"),
            VocabularyModel("a résumé"," a written description of your educación, abilities, and jobs."),
            VocabularyModel("a cover letter","a letter you write that goes with you résumé, highlighting details about your work experience"),
            VocabularyModel("a reference","someone who knows you well and can write a letter about you"),
            VocabularyModel("a skill","an ability to do something well")
        )
    }
}