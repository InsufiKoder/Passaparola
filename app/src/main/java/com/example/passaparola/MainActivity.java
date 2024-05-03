package com.example.passaparola;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final String ALPHABET = "ABCÇDEGHİJKLMNOPRSŞTYZ";
    String[] kelimelerArray = {"Ananas", "Astronomi", "Aslan", "Balina", "Basketbol", "Bisiklet", "Ceviz", "Cevap", "Cam", "Çikolata", "Çamaşır", "Çiçek", "Dinozor", "Dünya", "Dürüm", "Elma", "Efsane", "Evren", "Gitar", "Gözlük", "Güneş", "Havuç", "Hastane", "Hamburger", "İstanbul", "İncir", "İngilizce", "Jeton", "Judo", "Jazz", "Kalem", "Koala", "Kahve", "Limon", "Laptop", "Londra", "Muz", "Masa", "Mars", "Nar", "Not", "Nefes", "Orman", "Otomobil", "Okul", "Peynir", "Piyano", "Portakal", "Rüzgar", "Radyo", "Roma", "Saat", "Simit", "Spor", "Şemsiye", "Şeftali", "Şiir", "Tavuk", "Tren", "Televizyon", "Yılan", "Yemek", "Yılbaşı", "Zebra", "Zeytin", "Zaman"};
    String[] sorularArray = {"Hangi meyve sulu ve tatlı bir tadı vardır, ayrıca tropikal bir meyvedir?", "Uzayı inceleyen bilim dalına ne ad verilir?", "Hangi hayvan kral olarak bilinir ve genellikle büyük bir yele sahiptir?", "Hangi deniz canlısı dünyanın en büyük hayvanı olarak bilinir?", "Hangi spor dalında takımlar, bir topu rakip takımın potasına atmaya çalışır?", "İki tekerlekli, insan gücüyle hareket eden bir taşıt aracına ne ad verilir?", "Hangi kuruyemiş, içinde sert bir kabuğa sahip ve beyin sağlığı için faydalı omega-3 yağ asitleri içerir?", "Bir soruya verilen doğru yanıta ne denir?", "Pencereler genellikle hangi malzemeden yapılmıştır?", "Hangi tatlı, kakaodan yapılan ve genellikle farklı lezzetlerle tatlandırılan bir atıştırmalıdır?", "Evdeki kirli giysilere ne denilir?", "Bitkilerin üreme organı olan ve genellikle güzel kokulu olan hangi yapıya ne ad verilir?", "Hangi devasa hayvanlar, milyonlarca yıl önce dünyada yaşamıştır ve genellikle soyu tükenmiş olarak bilinir?", "Hangi gezegen, Güneş Sistemi'nde üçüncü sırada bulunur ve üzerinde yaşamı destekleyen tek bilinen yerdir?", "Hangi yiyecek, içine çeşitli malzemeler konularak sarılır ve genellikle elle yenir?", "Hangi meyve genellikle kırmızı veya yeşil renkte olup, birçok insan tarafından sevilir ve taze veya pişmiş olarak tüketilebilir?", "Hangi terim, gerçek olmayan veya abartılmış hikayeleri ifade etmek için kullanılır, genellikle popüler kültürde veya mitolojide bulunur?", "Hangi kavram, tüm madde, enerji, uzay ve zamanı içeren sonsuz genişlemeye sahip olan fiziksel ve kavramsal varlık bütününü ifade eder?", "Hangi müzik enstrümanı, telleri çekerek çalınır ve genellikle rock, pop, blues gibi müzik türlerinde kullanılır?", "Hangi eşya, görme yeteneğini düzeltmek veya güneş ışınlarını engellemek için kullanılır, genellikle cam veya plastikten yapılmış çerçeveli bir araçtır?", "Hangi yıldız, Güneş Sistemi'nin merkezinde bulunur ve Dünya'nın etrafında döner, ayrıca dünyamızı ısıtan ve aydınlatan kaynaktır?", "Hangi sebze turuncu renkte ve genellikle vitamin A ile ilişkilendirilir, ayrıca göz sağlığı için faydalıdır?", "Hangi yer, hastaların tedavi edildiği ve sağlık hizmetlerinin sunulduğu tıbbi bir kuruluştur?", "Hangi yiyecek, genellikle kıymadan yapılan bir köfte ve ekmeğin arasına konulmuş çeşitli malzemelerle hazırlanan bir fast-food ürünüdür?", "Hangi şehir, Türkiye'nin en kalabalık ve en büyük şehri olarak bilinir, aynı zamanda Asya ve Avrupa kıtaları arasında yer alır?", "Hangi meyve, genellikle mor veya kahverengi renkte olup tatlı bir tada sahiptir, ayrıca kurutulmuş veya taze olarak tüketilebilir?", "Hangi dil, dünya çapında en çok konuşulan ve genellikle uluslararası iletişim için kullanılan bir dildir?", "Hangi nesne, genellikle oyuncaklar, oyun makineleri veya toplu taşıma gibi yerlerde kullanılan küçük, yuvarlak ve metal veya plastikten yapılmış bir para birimidir?", "Hangi spor dalı, rakibi yere indirmek veya kontrol altına almak için kullanılan bir dövüş sporudur, aynı zamanda Japon kökenlidir?", "Hangi müzik türü, ritim ve özgürlüğü vurgulayan, genellikle enstrümantal olarak icra edilen ve kökenleri Amerika'ya dayanan bir türdür?", "Hangi araç, yazı veya çizim yapmak için kullanılır, genellikle mürekkep veya kurşun kalem gibi çeşitleri bulunur?", "Hangi hayvan, Avustralya'ya özgü bir memeli türüdür, genellikle ağaçlarda yaşar ve yapraklarla beslenir?", "Hangi içecek, genellikle sabahları uyanmak için veya dinlenmek için tüketilir, çekirdekleri kavrularak veya öğütülerek hazırlanır?", "Hangi meyve, ekşi bir tada sahip ve genellikle yemeklerde veya içeceklerde tatlandırıcı olarak kullanılır?", "Hangi cihaz, taşınabilir bir bilgisayar olarak bilinir, genellikle bir klavye ve bir ekranı bir araya getirir?", "Hangi şehir, İngiltere'nin başkenti olarak bilinir ve birçok turistik mekanıyla ünlüdür, örneğin Big Ben ve Buckingham Sarayı gibi?", "Hangi meyve, sarı bir kabuğa sahip ve genellikle enerji sağlamak için tüketilir, aynı zamanda potasyum açısından zengindir?", "Hangi mobilya parçası, yemek yemek, çalışmak veya diğer aktiviteler için kullanılır, genellikle düz bir yüzeye sahiptir ve sandalyelerle birlikte kullanılır?", "Hangi gezegen, Güneş Sistemi'nde Dünya'ya en yakın dördüncü gezegen olarak bilinir, ayrıca kızıl renkli bir yüzeye sahiptir ve insanlar tarafından keşfedilmeye çalışılmaktadır?", "Hangi meyve, kırmızı renkte ve içinde bol miktarda su dolu, yenilebilir çekirdekleri olan bir meyvedir?", "Hangi şey, bir bilgiyi hatırlamak veya iletmek için yazılı olarak kullanılan kısa bir mesaj veya belgeye verilen isimdir?", "Hangi eylem, oksijeni alıp karbondioksiti atmamızı sağlayan doğal bir vücut işlemidir?", "Hangi doğal alan, birçok ağaç, bitki ve hayvan türünü barındırır, genellikle büyük bir yeşil alanı kaplar ve oksijen üretimine katkıda bulunur?", "Hangi taşıt aracı, genellikle dört tekerleği olan ve insanları veya yükleri taşımak için motor gücüyle çalışan bir araçtır?", "Hangi kurum, genellikle çocukların eğitim aldığı ve öğrenim gördüğü bir yerdir, birçok farklı konuda dersler verilir ve öğretmenler tarafından yönetilir?", "Hangi yiyecek, sütün fermantasyonuyla yapılır ve genellikle ekmeğin üzerine sürülerek veya yemeklerde kullanılarak tüketilir?", "Hangi müzik enstrümanı, tuşlara basarak çalınır ve çeşitli müzik türlerinde kullanılır, genellikle birçok evde bulunur?", "Hangi meyve, turuncu renkte olup genellikle sıkılarak veya dilimlenerek tüketilir, aynı zamanda C vitamini açısından zengindir?", "Hangi doğal fenomen, hava hareketlerinin neden olduğu bir akımdır, genellikle ağaçları ve diğer nesneleri hareket ettirir?", "Hangi cihaz, genellikle müzik, haber veya sohbet programlarını kablosuz olarak iletmek için kullanılır, genellikle evlerde, arabalarda ve diğer yerlerde bulunur?", "Hangi şehir, İtalya'nın başkenti olarak bilinir ve tarih boyunca önemli bir kültürel ve tarihi merkez olarak hizmet vermiştir?", "Hangi cihaz, zamanı ölçmek için kullanılır, genellikle birkaç dakika boyunca dakika ve saniye göstergelerine sahip bir kadranı ve genellikle birkaç saatlik işaretleri olan bir yüzü bulunur?", "Hangi yiyecek, genellikle gevrek bir kabuğa sahip, halka şeklinde ve susam tohumlarıyla kaplıdır, Türk mutfağında sıkça tüketilir?", "Hangi aktivite, genellikle fiziksel egzersiz ve rekabet içerir, futbol, basketbol, yüzme gibi çeşitli türleri bulunur ve sağlıklı bir yaşam tarzının bir parçası olarak kabul edilir?", "Hangi eşya, yağmur veya güneş ışınlarından korunmak için kullanılır, genellikle açılır ve kapanır bir çerçeveye ve kumaş bir yüzeye sahiptir?", "Hangi meyve, tatlı ve sulu bir tada sahip, genellikle yaz aylarında tüketilen, yumuşak bir kabuğa ve bir çekirdeğe sahip bir meyvedir?", "Hangi sanat formu, kelimelerin ritmik bir şekilde düzenlenmesiyle oluşturulur, genellikle duygusal veya estetik bir ifade amacı taşır ve genellikle dize veya kafiye kullanılır?", "Hangi hayvan, genellikle yumurtladığı için yetiştirilir ve eti birçok yemekte kullanılır, aynı zamanda genellikle kanatları ve gagası bulunur?", "Hangi taşıt, demiryolu üzerinde hareket eder ve yolcuları veya yükleri bir yerden bir yere taşır, genellikle vagonlardan oluşur ve raylar üzerinde ilerler?", "Hangi cihaz, genellikle görsel ve işitsel içerikleri evlerde veya halka açık yerlerde yayınlamak için kullanılır, genellikle ekrana bağlı birçok kanalı ve programı içerir?", "Hangi hayvan, genellikle uzun, kaygan bir vücuda sahiptir ve zehirli veya zehirsiz olabilir, birçok türü sürüngenler sınıfına aittir?", "Hangi aktivite, yiyecekleri pişirme veya hazırlama işlemidir, genellikle insanlar tarafından günlük olarak gerçekleştirilir ve birçok kültürde önemli bir rol oynar?", "Hangi tatil, bir yılın sonunu ve bir sonraki yılın başlangıcını kutlar, genellikle 31 Aralık'ta kutlanır ve havai fişek gösterileri, parti ve aile toplantılarıyla kutlanır?", "Hangi hayvan, siyah ve beyaz şeritlere sahip bir posta sahiptir, genellikle Afrika'da yaşar ve genellikle çimenlik alanlarda otlanır?", "Hangi meyve, yeşil veya siyah renkte olabilir ve genellikle yağ üretimi veya yemeklerde kullanılmak üzere toplanır, aynı zamanda zeytinyağı elde etmek için sıkılır?", "Hangi kavram, olayların meydana geldiği süreci ifade eder, genellikle geçmiş, şimdi ve gelecek gibi farklı zaman dilimlerine ayrılır ve insanların hayatlarını düzenler?"};
    ArrayList<String> passAnswers = new ArrayList<>();
    ArrayList<String> passQuestions = new ArrayList<>();
    ArrayList<Integer> passQuestionIds = new ArrayList<>();
    ArrayList<String> wrongAnswers = new ArrayList<>();
    Button buttonExit, buttonPause, buttonSubmit;
    TextView textViewTimer, textViewQuestion;
    EditText editTextAnswer;
    int kelimeIndex = 0;
    int textViewID = 0;
    int puan = 0;
    int sure = 150;
    int sureMilliseconds = 150000;
    boolean isPaused = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConstraintLayout layout = findViewById(R.id.main);
        int radius = calculateRadius();
        Point center = getCenterPoint();
        double angleIncrement = Math.toRadians(360.0 / ALPHABET.length());

        for (int i = 0; i < ALPHABET.length(); i++) {
            char letter = ALPHABET.charAt(i);

            TextView textView = new TextView(this);
            textView.setId(1001+i);
            textView.setText(String.valueOf(letter));
            textView.setBackgroundResource(R.drawable.circular);
            textView.setPadding(20, 0, 0, 0);
            textView.setTextColor(Color.parseColor("#171717"));
            layout.addView(textView);

            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(layout);
            constraintSet.connect(textView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            constraintSet.connect(textView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.applyTo(layout);

            double angle = -Math.PI / 2 + angleIncrement * i;
            int x = (int) (center.x + radius * Math.cos(angle));
            int y = (int) (center.y + radius * Math.sin(angle));

            textView.setX(x - textView.getWidth() / 2);
            textView.setY(y - textView.getHeight() / 2);
        }

        setTimer("start");
        setQuestion();

        editTextAnswer = findViewById(R.id.editTextAnswer);
        editTextAnswer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                        System.out.println(textViewID);
                    if(textViewID >= 21) {
                        if(textViewID == 21) {
                            getAnswer();
                        }
                        checkPassTextViews();
                        if(passQuestions.isEmpty()){
                            setTimer("cancel");
                            puan = puan + (sure * 2);
                            finishGame();
                        }
                        setPassQuestion();
                        buttonSubmit = findViewById(R.id.buttonSubmitAnswer);
                        if(buttonSubmit.getVisibility() == View.INVISIBLE){
                            setTimer("cancel");
                            puan = puan + (sure * 2);
                            finishGame();
                        }
                    }
                    else{
                            getAnswer();
                            setQuestion();
                        }
                    return true;
                }
                return false;
            }
        });

        buttonSubmit = findViewById(R.id.buttonSubmitAnswer);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPassAnswers();
                if(passQuestions.isEmpty()){
                    setTimer("cancel");
                    puan = puan + (sure * 2);
                    finishGame();
                }
                setPassQuestion();
                if(checkPassTextViews())
                    checkPassTextViews();
                else{
                    setTimer("cancel");
                    puan = puan + (sure * 2);
                    finishGame();
                }
            }
        });

        buttonPause = findViewById(R.id.buttonPause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPaused) {
                    setTimer("cancel");
                    editTextAnswer.setEnabled(false);
                    buttonPause.setText("Başlat");
                    isPaused = true;
                } else{
                    setTimer("start");
                    editTextAnswer.setEnabled(true);
                    buttonPause.setText("Dur");
                    isPaused = false;
                }
            }
        });

        buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int calculateRadius() {
        return 420;
    }

    private Point getCenterPoint() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int centerX = (size.x / 2)-28;
        int centerY = size.y / 2;

        return new Point(centerX, centerY);
    }
    int arrayIndex = 0;
    private void setQuestion(){
        textViewQuestion = findViewById(R.id.textViewQuestion);
        System.out.println(1001+textViewID);
        int max = arrayIndex + 2;
        int min = arrayIndex;
        int range = max - min + 1;
        int rastgeleSayi = (int)(Math.random() * range) + min;
        if(rastgeleSayi >= 66)
            rastgeleSayi = 65;
        System.out.println("SAYI: " + rastgeleSayi);
        String question = sorularArray[rastgeleSayi];
        kelimeIndex = rastgeleSayi;
        textViewQuestion.setText(question);

        arrayIndex += 3;
    }
    private void getAnswer(){
        TextView textView = findViewById(1001+textViewID);
        editTextAnswer = findViewById(R.id.editTextAnswer);

        String questionAnswer = kelimelerArray[kelimeIndex];
        String answer = editTextAnswer.getText().toString();
        String buyukKucuk = "";
        if(!answer.isEmpty()){
            buyukKucuk = answer.substring(0, 1).toUpperCase().trim() + answer.substring(1).toLowerCase().trim();
        }

        if(questionAnswer.equals(buyukKucuk)){
            textView.setBackgroundResource(R.drawable.circular_green);
            puan += 100;
        }
        else if(buyukKucuk.isEmpty()){
            textView.setBackgroundResource(R.drawable.circular_orange);
            passAnswers.add(questionAnswer);
            passQuestions.add(sorularArray[kelimeIndex]);
            passQuestionIds.add(1001+textViewID);
        }
        else if(questionAnswer != buyukKucuk){
            textView.setBackgroundResource(R.drawable.circular_red);
            wrongAnswers.add(questionAnswer);
            puan -= 25;
        }

        editTextAnswer.setText("");
        textViewID += 1;
    }
    private void finishGame(){
        if(puan < 0)
            puan = 0;
        Intent intent = new Intent(MainActivity.this, endscreen.class);
        intent.putExtra("puan", puan);
        intent.putStringArrayListExtra("passQuestions", passAnswers);
        intent.putStringArrayListExtra("wrongQuestions", wrongAnswers);
        startActivity(intent);
        finish();
    }
    private CountDownTimer countDownTimer;
    private void setTimer(String method){
        textViewTimer = findViewById(R.id.textViewTimer);
        if(method.equals("start")){
            countDownTimer = new CountDownTimer(sureMilliseconds, 1000) {
                public void onTick(long millisUntilFinished) {
                    textViewTimer.setText("Kalan süre: " + millisUntilFinished / 1000 + " Saniye");
                    sure -= 1;
                    sureMilliseconds -= 1000;
                }
                public void onFinish() {
                    puan = puan + (sure * 2);
                    finishGame();
                }
            }.start();
        }
        else if(method.equals("cancel")){
            countDownTimer.cancel();
        }
    }

    int id;
    int passQuestionId;
    String passAnswer;
    private boolean checkPassTextViews() {
        for (int i = 0; i <= 21; i++) {
            TextView textView = findViewById(1001 + i);
            id = 1001 + i;
            if (textView != null) {
                Drawable backgroundDrawable = textView.getBackground();
                if (backgroundDrawable != null && backgroundDrawable.getConstantState() != null) {
                    if (backgroundDrawable.getConstantState().equals(ContextCompat.getDrawable(MainActivity.this, R.drawable.circular_orange).getConstantState())) {
                        for (int j = 0; j < passQuestionIds.size(); j++) {
                            int id = passQuestionIds.get(j);
                            if (textView.getId() == id) {
                                System.out.println("FOUND textView " + id);
                                passAnswer = passAnswers.get(0);
                                passQuestionId = 0;
                                System.out.println("CEVAP " + passAnswer);

                                buttonSubmit = findViewById(R.id.buttonSubmitAnswer);
                                buttonSubmit.setVisibility(View.VISIBLE);
                                buttonSubmit.setEnabled(true);

                                editTextAnswer = findViewById(R.id.editTextAnswer);
                                editTextAnswer.setOnClickListener(null);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void setPassQuestion(){
        if(!passQuestions.isEmpty()){
            textViewQuestion = findViewById(R.id.textViewQuestion);
            textViewQuestion.setText(passQuestions.get(passQuestionId));
        }
    }
    private void getPassAnswers() {
        TextView textView = findViewById(id);
        editTextAnswer = findViewById(R.id.editTextAnswer);

        String userAnswer = editTextAnswer.getText().toString().trim();
        String capitalizedAnswer = "";
        if(!userAnswer.isEmpty())
            capitalizedAnswer = userAnswer.substring(0, 1).toUpperCase() + userAnswer.substring(1).toLowerCase();

        if (passAnswer.equals(capitalizedAnswer)) {
            textView.setBackgroundResource(R.drawable.circular_green);
            passAnswers.remove(passAnswer);
            passQuestions.remove(passQuestions.get(passQuestionId));
            puan += 100;
        } else {
            textView.setBackgroundResource(R.drawable.circular_red);
            wrongAnswers.add(passAnswer);
            passAnswers.remove(passAnswer);
            passQuestions.remove(passQuestions.get(passQuestionId));
            puan -= 25;
        }
        editTextAnswer.setText("");
    }
}
