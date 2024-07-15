import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private List<Question> questions;

    public QuestionBank() {
        questions = new ArrayList<>();
        questions.add(new Question("Sports", "What sport does Zambian athlete Kabange Mupopo compete in?", new String[]{"Athletics", "Boxing", "Football", "Swimming"}, "Athletics"));
        questions.add(new Question("Sports", "Which Zambian football club is based in Ndola?", new String[]{"ZESCO United", "Zanaco FC", "Power Dynamos", "Nkana FC"}, "ZESCO United"));
        populateQuestions();
    }

    public List<Question> getQuestions(String category) {
        List<Question> categoryQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getCategory().equalsIgnoreCase(category)) {
                categoryQuestions.add(question);
            }
        }
        return categoryQuestions;
    }

    private void populateQuestions() {
        // Add questions for Category 1: Geography
        questions.add(new Question("Geography", "What is the capital city of Zambia?", new String[]{"Lusaka", "Kitwe", "Ndola", "Livingstone"}, "Lusaka"));
        questions.add(new Question("Geography", "Which river forms the border between Zambia and Zimbabwe?", new String[]{"Zambezi River", "Luangwa River", "Kafue River", "Congo River"}, "Zambezi River"));
        questions.add(new Question("Geography", "What is the name of Zambia's highest peak?", new String[]{"Mafinga Central", "Kilimanjaro", "Mount Kenya", "Drakensberg"}, "Mafinga Central"));
        questions.add(new Question("Geography", "Which of the following is NOT a major city in Zambia?", new String[]{"Livingstone", "Ndola", "Chingola", "Nairobi"}, "Nairobi"));
        questions.add(new Question("Geography", "Zambia shares its longest border with which country?", new String[]{"Democratic Republic of the Congo", "Tanzania", "Zimbabwe", "Angola"}, "Democratic Republic of the Congo"));
        questions.add(new Question("Geography", "What is the largest national park in Zambia?", new String[]{"Kafue National Park", "South Luangwa National Park", "Lower Zambezi National Park", "Liuwa Plain National Park"}, "Kafue National Park"));
        questions.add(new Question("Geography", "In which province is the Victoria Falls located?", new String[]{"Southern Province", "Northern Province", "Eastern Province", "Western Province"}, "Southern Province"));
        questions.add(new Question("Geography", "What is the main river flowing through Zambia?", new String[]{"Zambezi River", "Nile River", "Limpopo River", "Orange River"}, "Zambezi River"));
        questions.add(new Question("Geography", "How many provinces does Zambia have?", new String[]{"10", "8", "12", "9"}, "10"));
        questions.add(new Question("Geography", "What is the name of the waterfall located in Northern Province?", new String[]{"Kalambo Falls", "Victoria Falls", "Mosi-oa-Tunya Falls", "Chimanimani Falls"}, "Kalambo Falls"));
        questions.add(new Question("Geography", "What is the name of the famous wildlife sanctuary in Zambia?", new String[]{"South Luangwa National Park", "Serengeti National Park", "Kruger National Park", "Hwange National Park"}, "South Luangwa National Park"));
        questions.add(new Question("Geography", "Which province is known for its copper mines?", new String[]{"Copperbelt Province", "Eastern Province", "Northern Province", "Southern Province"}, "Copperbelt Province"));
        questions.add(new Question("Geography", "Which lake is shared by Zambia and Tanzania?", new String[]{"Lake Tanganyika", "Lake Victoria", "Lake Malawi", "Lake Chad"}, "Lake Tanganyika"));
        questions.add(new Question("Geography", "What is the main language spoken in Lusaka?", new String[]{"English", "Bemba", "Nyanja", "Tonga"}, "Nyanja"));
        questions.add(new Question("Geography", "What is the approximate population of Zambia?", new String[]{"18 million", "12 million", "25 million", "30 million"}, "18 million"));
        questions.add(new Question("Geography", "Which province is Ndola located in?", new String[]{"Copperbelt Province", "Central Province", "Lusaka Province", "Northern Province"}, "Copperbelt Province"));
        questions.add(new Question("Geography", "What is the currency of Zambia?", new String[]{"Zambian Kwacha", "Zimbabwean Dollar", "Tanzanian Shilling", "Malawian Kwacha"}, "Zambian Kwacha"));
        questions.add(new Question("Geography", "What is the predominant religion in Zambia?", new String[]{"Christianity", "Islam", "Hinduism", "Buddhism"}, "Christianity"));
        questions.add(new Question("Geography", "Which country lies to the north of Zambia?", new String[]{"Democratic Republic of the Congo", "Namibia", "Botswana", "Zimbabwe"}, "Democratic Republic of the Congo"));
        questions.add(new Question("Geography", "What is the main agricultural product of Zambia?", new String[]{"Maize", "Rice", "Wheat", "Coffee"}, "Maize"));

        // Add questions for Category 2: History
        questions.add(new Question("History", "When did Zambia gain independence from Britain?", new String[]{"1964", "1974", "1954", "1984"}, "1964"));
        questions.add(new Question("History", "Who was the first President of Zambia?", new String[]{"Kenneth Kaunda", "Levy Mwanawasa", "Frederick Chiluba", "Michael Sata"}, "Kenneth Kaunda"));
        questions.add(new Question("History", "What was Zambia called before independence?", new String[]{"Northern Rhodesia", "Southern Rhodesia", "Zaire", "Nyasaland"}, "Northern Rhodesia"));
        questions.add(new Question("History", "Which movement led Zambia to independence?", new String[]{"United National Independence Party (UNIP)", "African National Congress (ANC)", "Movement for Multi-Party Democracy (MMD)", "Patriotic Front (PF)"}, "United National Independence Party (UNIP)"));
        questions.add(new Question("History", "When did Zambia become a republic?", new String[]{"1964", "1974", "1984", "1994"}, "1964"));
        questions.add(new Question("History", "Who succeeded Kenneth Kaunda as President of Zambia?", new String[]{"Frederick Chiluba", "Rupiah Banda", "Levy Mwanawasa", "Michael Sata"}, "Frederick Chiluba"));
        questions.add(new Question("History", "What year did Zambia host the African Cup of Nations (AFCON)?", new String[]{"1986", "1996", "2012", "2002"}, "2012"));
        questions.add(new Question("History", "What is the name of the colonial administrator who named Northern Rhodesia?", new String[]{"Cecil Rhodes", "David Livingstone", "Robert Moffat", "Frederick Lugard"}, "Cecil Rhodes"));
        questions.add(new Question("History", "When was the first multi-party election held in Zambia?", new String[]{"1991", "1981", "2001", "2011"}, "1991"));
        questions.add(new Question("History", "Which country was Zambia's main ally during the liberation struggle?", new String[]{"Tanzania", "South Africa", "Kenya", "Nigeria"}, "Tanzania"));
        questions.add(new Question("History", "What was the main reason for the construction of the Kariba Dam?", new String[]{"Hydroelectric power", "Flood control", "Irrigation", "Tourism"}, "Hydroelectric power"));
        questions.add(new Question("History", "Which Zambian President introduced the Third Republic?", new String[]{"Frederick Chiluba", "Kenneth Kaunda", "Rupiah Banda", "Michael Sata"}, "Frederick Chiluba"));
        questions.add(new Question("History", "When did Zambia join the United Nations?", new String[]{"1964", "1974", "1954", "1984"}, "1964"));
        questions.add(new Question("History", "What was the significant event in Zambia in 1991?", new String[]{"Introduction of multi-party democracy", "Hosting the African Cup of Nations", "Completion of the TAZARA railway", "Independence from Britain"}, "Introduction of multi-party democracy"));
        questions.add(new Question("History", "Who was the President of Zambia during the transition to multi-party democracy?", new String[]{"Kenneth Kaunda", "Frederick Chiluba", "Levy Mwanawasa", "Rupiah Banda"}, "Kenneth Kaunda"));
        questions.add(new Question("History", "What was the name of the first national anthem of Zambia?", new String[]{"Stand and Sing of Zambia, Proud and Free", "Nkosi Sikelel' iAfrika", "God Save the Queen", "The Star-Spangled Banner"}, "Stand and Sing of Zambia, Proud and Free"));
        questions.add(new Question("History", "Who was the first Vice President of Zambia?", new String[]{"Reuben Kamanga", "Simon Kapwepwe", "Mainza Chona", "Levy Mwanawasa"}, "Reuben Kamanga"));
        questions.add(new Question("History", "What year did Zambia change its name from Northern Rhodesia to Zambia?", new String[]{"1964", "1974", "1984", "1994"}, "1964"));
        questions.add(new Question("History", "What event is celebrated on October 24th in Zambia?", new String[]{"Independence Day", "Heroes Day", "Labour Day", "Africa Freedom Day"}, "Independence Day"));
        questions.add(new Question("History", "Who was the Zambian President from 2002 to 2008?", new String[]{"Levy Mwanawasa", "Michael Sata", "Rupiah Banda", "Kenneth Kaunda"}, "Levy Mwanawasa"));

        // Add questions for Category 3: Culture
        questions.add(new Question("Culture", "What is the traditional ceremony of the Lozi people called?", new String[]{"Kuomboka", "Nc’wala", "Mutomboko", "Shimunenga"}, "Kuomboka"));
        questions.add(new Question("Culture", "Which tribe is primarily found in the Northern Province of Zambia?", new String[]{"Bemba", "Lozi", "Tonga", "Ngoni"}, "Bemba"));
        questions.add(new Question("Culture", "What is the staple food of Zambia?", new String[]{"Nshima", "Rice", "Bread", "Potatoes"}, "Nshima"));
        questions.add(new Question("Culture", "What is the name of the traditional Zambian drink made from maize?", new String[]{"Maheu", "Kachasu", "Chibwantu", "Munkoyo"}, "Maheu"));
        questions.add(new Question("Culture", "Which Zambian tribe celebrates the Nc’wala ceremony?", new String[]{"Ngoni", "Lozi", "Bemba", "Tonga"}, "Ngoni"));
        questions.add(new Question("Culture", "What is the name of the traditional attire worn by Zambian women?", new String[]{"Chitenge", "Sari", "Kimono", "Dashiki"}, "Chitenge"));
        questions.add(new Question("Culture", "What is the traditional dance of the Bemba people?", new String[]{"Makishi", "Ingoma", "Chinamwali", "Mbende"}, "Makishi"));
        questions.add(new Question("Culture", "Which Zambian artist is known for the song \"Dora\"?", new String[]{"JK", "Macky 2", "Slapdee", "Petersen"}, "JK"));
        questions.add(new Question("Culture", "What is the name of the Zambian dish made from groundnuts and vegetables?", new String[]{"Ifisashi", "Kapenta", "Chikanda", "Samp"}, "Ifisashi"));
        questions.add(new Question("Culture", "Which Zambian tribe is known for the Mutomboko ceremony?", new String[]{"Lunda", "Bemba", "Tonga", "Ngoni"}, "Lunda"));
        questions.add(new Question("Culture", "What is the name of the Zambian traditional music genre?", new String[]{"Kalindula", "Soukous", "Afrobeat", "Kwaito"}, "Kalindula"));
        questions.add(new Question("Culture", "Which Zambian author wrote \"The Gentleman\"?", new String[]{"Kenneth Kaunda", "Dambisa Moyo", "Binwell Sinyangwe", "Dominic Mulaisho"}, "Dominic Mulaisho"));
        questions.add(new Question("Culture", "What is the main ingredient in the Zambian dish \"Ifinkubala\"?", new String[]{"Caterpillars", "Fish", "Chicken", "Beef"}, "Caterpillars"));
        questions.add(new Question("Culture", "What is the traditional ceremony of the Tonga people called?", new String[]{"Lwiindi", "Nc’wala", "Kuomboka", "Shimunenga"}, "Lwiindi"));
        questions.add(new Question("Culture", "Who is the famous Zambian artist known for the song \"Chipolopolo\"?", new String[]{"Danny Kaya", "Mampi", "JK", "Slapdee"}, "Danny Kaya"));
        questions.add(new Question("Culture", "What is the Zambian festival celebrated at the end of the harvest season?", new String[]{"Lwiindi", "Kuomboka", "Nc’wala", "Shimunenga"}, "Lwiindi"));
        questions.add(new Question("Culture", "What is the traditional beer of Zambia made from sorghum or maize?", new String[]{"Chibuku", "Maheu", "Kachasu", "Munkoyo"}, "Chibuku"));
        questions.add(new Question("Culture", "What is the Zambian term for a traditional healer?", new String[]{"Ng’anga", "Sangoma", "Mfundisi", "Dokotala"}, "Ng’anga"));
        questions.add(new Question("Culture", "Which Zambian tribe is known for the Shimunenga ceremony?", new String[]{"Ila", "Tonga", "Bemba", "Lozi"}, "Ila"));
        questions.add(new Question("Culture", "What is the name of the Zambian traditional musical instrument similar to a xylophone?", new String[]{"Silimba", "Marimba", "Mbira", "Kalimba"}, "Silimba"));

        // Add questions for Category 4: Economy
        questions.add(new Question("Economy", "What is the primary export product of Zambia?", new String[]{"Copper", "Gold", "Diamonds", "Oil"}, "Copper"));
        questions.add(new Question("Economy", "Which sector is the largest employer in Zambia?", new String[]{"Agriculture", "Mining", "Manufacturing", "Services"}, "Agriculture"));
        questions.add(new Question("Economy", "What is the name of Zambia’s central bank?", new String[]{"Bank of Zambia", "Reserve Bank of Zambia", "Central Bank of Zambia", "National Bank of Zambia"}, "Bank of Zambia"));
        questions.add(new Question("Economy", "Which mineral is Zambia particularly rich in?", new String[]{"Copper", "Gold", "Silver", "Platinum"}, "Copper"));
        questions.add(new Question("Economy", "What is the primary industry in the Copperbelt Province?", new String[]{"Mining", "Agriculture", "Tourism", "Manufacturing"}, "Mining"));
        questions.add(new Question("Economy", "What currency is used in Zambia?", new String[]{"Zambian Kwacha", "Zambian Dollar", "Zambian Pound", "Zambian Shilling"}, "Zambian Kwacha"));
        questions.add(new Question("Economy", "Which country is the largest importer of Zambian copper?", new String[]{"China", "United States", "India", "Japan"}, "China"));
        questions.add(new Question("Economy", "What is Zambia’s main agricultural export?", new String[]{"Tobacco", "Maize", "Coffee", "Tea"}, "Tobacco"));
        questions.add(new Question("Economy", "Which international organization provides loans and financial assistance to Zambia?", new String[]{"International Monetary Fund (IMF)", "World Bank", "African Development Bank", "Asian Development Bank"}, "World Bank"));
        questions.add(new Question("Economy", "What is the main source of electricity in Zambia?", new String[]{"Hydropower", "Solar power", "Wind power", "Thermal power"}, "Hydropower"));
        questions.add(new Question("Economy", "Which economic zone was established to attract foreign investment in Zambia?", new String[]{"Multi-Facility Economic Zone (MFEZ)", "Special Economic Zone (SEZ)", "Free Trade Zone (FTZ)", "Export Processing Zone (EPZ)"}, "Multi-Facility Economic Zone (MFEZ)"));
        questions.add(new Question("Economy", "Which Zambian city is known for its emerald mines?", new String[]{"Ndola", "Kitwe", "Lusaka", "Livingstone"}, "Kitwe"));
        questions.add(new Question("Economy", "What is the name of the largest copper mine in Zambia?", new String[]{"Kansanshi Mine", "Lumwana Mine", "Mopani Mine", "Konkola Mine"}, "Kansanshi Mine"));
        questions.add(new Question("Economy", "What is the Zambian government’s main source of revenue?", new String[]{"Taxes", "Foreign aid", "Tourism", "Remittances"}, "Taxes"));
        questions.add(new Question("Economy", "Which Zambian city is known for its role in the transport of goods?", new String[]{"Ndola", "Livingstone", "Chipata", "Kasama"}, "Ndola"));
        questions.add(new Question("Economy", "What is the primary agricultural product of Southern Province?", new String[]{"Maize", "Wheat", "Rice", "Coffee"}, "Maize"));
        questions.add(new Question("Economy", "Which sector is the fastest-growing in Zambia’s economy?", new String[]{"Construction", "Agriculture", "Mining", "Tourism"}, "Construction"));
        questions.add(new Question("Economy", "What type of economy does Zambia have?", new String[]{"Mixed economy", "Command economy", "Market economy", "Traditional economy"}, "Mixed economy"));
        questions.add(new Question("Economy", "What is the name of Zambia’s stock exchange?", new String[]{"Lusaka Stock Exchange (LuSE)", "Zambian Stock Exchange (ZaSE)", "Copperbelt Stock Exchange (CoSE)", "Zambezi Stock Exchange (ZaSE)"}, "Lusaka Stock Exchange (LuSE)"));
        questions.add(new Question("Economy", "Which Zambian city is the commercial and industrial hub of the country?", new String[]{"Lusaka", "Kitwe", "Ndola", "Livingstone"}, "Lusaka"));

        // Add questions for Category 5: Sports
        questions.add(new Question("Sports", "What is the national football team of Zambia called?", new String[]{"Chipolopolo", "Bafana Bafana", "Black Stars", "Super Eagles"}, "Chipolopolo"));
        questions.add(new Question("Sports", "In which year did Zambia win the Africa Cup of Nations (AFCON)?", new String[]{"2012", "1996", "2002", "2016"}, "2012"));
        questions.add(new Question("Sports", "Who was the captain of the Zambian football team during the 2012 AFCON victory?", new String[]{"Christopher Katongo", "Rainford Kalaba", "Kennedy Mweene", "Stoppila Sunzu"}, "Christopher Katongo"));
        questions.add(new Question("Sports", "Which Zambian footballer has played for the English Premier League?", new String[]{"Emmanuel Mayuka", "Kalusha Bwalya", "Godfrey Chitalu", "Alex Chola"}, "Emmanuel Mayuka"));
        questions.add(new Question("Sports", "What is the main sport played in Zambia?", new String[]{"Football", "Rugby", "Cricket", "Basketball"}, "Football"));
        questions.add(new Question("Sports", "Which Zambian football club is based in Kitwe?", new String[]{"Nkana FC", "ZESCO United", "Green Buffaloes", "Red Arrows"}, "Nkana FC"));
        questions.add(new Question("Sports", "Who is Zambia’s most famous female athlete?", new String[]{"Esther Phiri", "Catherine Phiri", "Barbara Banda", "Kabange Mupopo"}, "Esther Phiri"));
        questions.add(new Question("Sports", "What is the name of the stadium in Lusaka used for major football matches?", new String[]{"National Heroes Stadium", "Independence Stadium", "Levy Mwanawasa Stadium", "Dag Hammarskjöld Stadium"}, "National Heroes Stadium"));
        questions.add(new Question("Sports", "Which Zambian boxer is known as the \"African Queen\"?", new String[]{"Esther Phiri", "Catherine Phiri", "Lolita Muzeya", "Barbara Banda"}, "Esther Phiri"));
        questions.add(new Question("Sports", "Which Zambian football club has won the most league titles?", new String[]{"Nkana FC", "ZESCO United", "Power Dynamos", "Zanaco FC"}, "Nkana FC"));
        questions.add(new Question("Sports", "Who was the first Zambian to win an Olympic medal?", new String[]{"Samuel Matete", "Mathews Tembo", "John Mwanza", "Muna Singh"}, "Samuel Matete"));
        questions.add(new Question("Sports", "Which sport is associated with the annual Victoria Falls Marathon?", new String[]{"Running", "Cycling", "Swimming", "Triathlon"}, "Running"));
        questions.add(new Question("Sports", "Which Zambian city hosted the 2019 All-Africa Games?", new String[]{"Lusaka", "Kitwe", "Ndola", "Livingstone"}, "Lusaka"));
        questions.add(new Question("Sports", "Who is the famous Zambian footballer known for his goal-scoring record in Africa?", new String[]{"Godfrey Chitalu", "Kalusha Bwalya", "Alex Chola", "Rainford Kalaba"}, "Godfrey Chitalu"));
        questions.add(new Question("Sports", "What is the nickname of the Zambian women's national football team?", new String[]{"Shepolopolo", "Copper Queens", "Lady Eagles", "Female Warriors"}, "Shepolopolo"));
        questions.add(new Question("Sports", "Which Zambian rugby club is based in Lusaka?", new String[]{"Red Arrows RFC", "Mufulira RFC", "Ndola Wanderers RFC", "Diggers RFC"}, "Red Arrows RFC"));
        questions.add(new Question("Sports", "Who is Zambia’s record goal scorer in international football?", new String[]{"Godfrey Chitalu", "Kalusha Bwalya", "Christopher Katongo", "Collins Mbesuma"}, "Godfrey Chitalu"));
        questions.add(new Question("Sports", "Which Zambian swimmer represented the country at the 2016 Olympics?", new String[]{"Tilka Paljk", "Roy Allan Burch", "Jade Howard", "Zane Jordan"}, "Tilka Paljk"));
        questions.add(new Question("Sports", "What sport does Zambian athlete Kabange Mupopo compete in?", new String[]{"Athletics", "Boxing", "Football", "Swimming"}, "Athletics"));
        questions.add(new Question("Sports", "Which Zambian football club is based in Ndola?", new String[]{"ZESCO United", "Zanaco FC", "Power Dynamos", "Nkana FC"}, "ZESCO United"));
    }
}

