package nrv.bstu.myapplication;

public class Questions {


    public String mQuestions[] = {
            "Выберите основные методы жизненного цикла приложения",
            "Какой метод следует после метода onCreate",
            "Назовите способы хранения данных в Android",
            "Какие типы меню существуют в Android",
            "Какие существуют диалоговые окна",
            "Выберите объекты, используемые в SQLite",
            "Выберите тип данных поддерживаемый в SQLite",
            "Метод жизненного цикла фрагмента",
            "Какие циклы можно использовать в Kotlin",


    };

    public String mChoices[][] = {
            {"onCast","onCreatePause","onResume","onReload"},
            {"onResume","onDestroy","onResume","onStart"},
            {"MSSQL","Externational Storage","SQLite","Shared references"},
            {"Internal Menu","External Menu","Popup Menu","Optium menu"},
            {"Ambulance Dialog","SymbolPickerDialog","AlertDialog","Phone Dialog"},
            {"SQLiteOpenHandler","SQLiteData","SQLiteOpenHelper","MSSQL"},
            {"NVarChar","VarChar","Date","Blob"},
            {"onFragmentCreate","onDestroyView","onStopView","onResumeFragment"},
            {"do","when","foreach","continue"},

    };

    public String mCorrectAnswers[] = {
            "onResume",
            "onStart",
            "SQLite",
            "Popup Menu",
            "AlertDialog",
            "SQLiteOpenHelper",
            "Blob",
            "onDestroyView",
            "when",

    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnser(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
