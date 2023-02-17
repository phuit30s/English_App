package lad1.example.englishapp;

public class Question {
    public String questions[] = {
            "He's very short: ________ sisters are taller.",
            "When ________ dinner.",
            "Kate is the best ________ the three.",
            "Peter works in London. ________.",
            "The hotel is ________.",
            "Leave your dirty shoes ________ the door.",
            "He ________ swim very well.",
            "- Can we begin the test? - We can't unless the teacher ________ so.",
            "\"You are late\" he said. \"I think the bus ________ already.\"",
            "We wondered who was going to pay for the ________ window.",
            "The pond near your house is full ________ white lilies.",
            "His landlady doesn't ________ of his having parties.",
            "I drink ________ coffee than you.",
            "I bought her a new pencil sharpener ________.",
            "The news ________ as soon as possible.",
            "This book is ________.",
            "Suda told ________ the whole story.",
            "It's a small shop, and you may have some difficulty ________ it.",
            "- Are you ready? - ________.",
            "Yeuk Yee had her house painted white yesterday.\n= > ___________________________________."
    };

    public String choices[][] = {
            {"(A) both of them", "(B) his both", "(C) both his", "(D) the two both his"},
            {"(A) have you", "(B) do you have", "(C) you have", "(D) you are having"},
            {"(A) in", "(B) from", "(C) than", "(D) of"},
            {"(A) He goes there by train","(B) He there goes by train","(C) He goes by train there","(D) There goes he by train"},
            {"(A) sell","(B) for sale","(C) for sell","(D) sale"},
            {"(A) out from","(B) out","(C) outside","(D) out of"},
            {"(A) not can","(B) cannot","(C) doesn't can","(D) don't can"},
            {"(A) will say","(B) is saying","(C) shall say","(D) says"},
            {"(A) went","(B) was going","(C) has gone","(D) goes"},
            {"(A) broken","(B) breaking","(C) broke","(D) break"},
            {"(A) with","(B) of","(C) to","(D) zero"},
            {"(A) appreciate","(B) support","(C) approve","(D) agree"},
            {"(A) little","(B) few","(C) less","(D) fewer"},
            {"(A) it is very expensive","(B) which was very expensive","(C) whose colour was black","(D) it will be vey expensive"},
            {"(A) release","(B) will release","(C) will have been released","(D) will be released"},
            {"(A) belonged to Som","(B) belong to Som","(C) Som's","(D) of Som"},
            {"(A) to me","(B) me","(C) I","(D) my"},
            {"(A) to find","(B) of finding","(C) in finding","(D) to be finding"},
            {"(A) Already not","(B) Quite not","(C) Yet not","(D) Not yet"},
            {"(A) She had to paint her house white yesterday.","(B) Her house was not blue last week.","(C) They painted her house white for her yesterday.","(D) She painted her house yesterday."}
    };

    public String correctAnswer[] = {
            "(C) both his",
            "(B) do you have",
            "(D) of",
            "(A) He goes there by train",
            "(B) for sale",
            "(C) outside",
            "(B) cannot",
            "(D) says",
            "(C) has gone",
            "(A) broken",
            "(B) of",
            "(C) approve",
            "(C) less",
            "(B) which was very expensive",
            "(D) will be released",
            "(C) Som's",
            "(B) me",
            "(C) in finding",
            "(D) Not yet",
            "(C) They painted her house white for her yesterday."
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
