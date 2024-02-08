package com.challenge;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PalindromeExample {

    public static int palindromeIndex(String s) {
        int index = -1;
        int from = 0;
        int to = s.length() - 1;
        int count = 0;

        while (from < to) {
            if (count > 1)
                return -1;
            if (s.charAt(from) == s.charAt(to)) {
                from++;
                to--;
            } else if (s.charAt(from) == s.charAt(to-1)) {
                index = to;
                count++;
                to-=2;
                from++;
            } else if (s.charAt(from+1) == s.charAt(to)) {
                index = from;
                count++;
                from+=2;
                to--;
            } else {
                return -1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        String s = "lhrxvssvxrhl\n" +
                "prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp\n" +
                "kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk";
        String s1 = "quyjjdcgsvvsgcdjjyq\n" +
                "hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh\n" +
                "fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf\n" +
                "bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb\n" +
                "fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf\n" +
                "mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm\n" +
                "tpqknkmbgasitnwqrqasvolmevkasccsakvemlosaqrqwntisagbmknkqpt\n" +
                "lhrxvssvxrhl\n" +
                "prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp";
        String s2 = "fyjwtatuieusvfqaeynaaiiaanyeaqfvsueutatwjyf\n" +
                "qaaiyrpadovfjrmgkildtkseysejdtrpltptujlxxljutptlprtdjesyeskdlikgmrjfvodapryiaaq\n" +
                "llhrxcreddwkcronujfkwbdswoowsdbwkfjunorckwdderxrhll\n" +
                "qasfhkfcojhntlfkaydtepsfsleipymwsopposwmypielsfspetdykfltnhjocfkhfsaq\n" +
                "broifqivnnvifiorb\n" +
                "bglgcwnmpobohqefrglsaaaaslgrfeqhobopmnwcglgb\n" +
                "bthvmywukfwrkslaiialskwfkuwymvhtb\n" +
                "uxxdlselxmwyiguugtpsypfudffswvwyswyyiiyywsywvsffdufpysptguugiywmxlesldxxu\n" +
                "rvscdpyljqglgmiktfndsmfnkgmubrruloqptgohsgneocoyyocoengshogtpqolurrbumgknfmsdntkimglgqjlypdcsvr";
        String s3 = "aprrmdeykhorwsalkysinbvylgcgiaokrifgolfytvsqqufctxkjbijnonvapmkivrokewlasfskcxowyyiakrpyilyxbmgygxjkuwmpegcheqgdsogdjverkgpnuymbyxovublchqjojptegahpyojlucypdnqclfxijlkqevhoncsuedmftwsoytgchygsheeqrojwlrnbvivanjihibvjvelderylxderrnqffehdnfebqmlypjilovrspqgpvkipabvigflvkryegkdwuoklmcedumuqyfhyhfjpkvnwnmbuahtwxeikjopednxcsfdcmnrwlfvbuaxwhrthyeriskovxoasvdvisnhgveisggppblwapqkkbbiyqismnqvhgdnejxwrfohgaeirvuewvmyoutcjkassfixphuhmmruovfhtaltxysnvophbpatwjrmspwhcqcqmjahjobhpvulmmtnevjchcqarphvglmvwpfgeiqtenfsdbghxplhtdknstjciyxfofmsnfmtutmxvugvmrfhwpwsmjuukuabaovpvijrevpcqxadqgmpxmikvfhgcijcyfrvpdntydyrcyxuhmkiyvuwbdfenoimtdkjgxgiefaigxdonpwmltmpwrvkheadhkpqlvypbyxhadxnswchroyojucsyevjonaajyrmarwcuwpquuamlyduvhpulogdcidojxbmpaonxhescehpfknbudxgthjwpplcnoofpdsnmyiofphkcunwaoguvptnhfpwtgdlmxyyxjqdyxqeuedwujrqalhjswhpgmbskdrimiooifsdlvdhiuakjhtehbtnnxgbbajpjagtfyatxdbiabsjlmosqkggiohjotcatiuckuvkaysaclknabgqloxudfgsbisvtpxemtomuhnwualubtmojmjmtqhvbbruqrygnpsiwghriupjpcyboknkdvgfyacrrexhtrptaxnjudukhvlxhcjkapryswqkbrswlkqlkfwgkussqhqajanjsfklcdxfusdgetuqbtymoshicxilbvwtcjhgmfokyrsfnpvrkxgbsnjunsioofksqrcdxqpwijexyaplavnsjwnxpvohdaattcatspqdbwcbxroxqctcahargryjtcenegiavbdxyhbycrysusuwdxqjrqslsybyflyenfeomhpoyqjvkfspfkywdtixtlybxyhlencsuriwktsuymmgyldegnccabfxcnlidpcyjmvtgorideocsuiyimdkqkksxxcengdysbtyrnjvryaktjlevormaciabmeqsjqnkmofaybrxdftoqanirckwkmxytqrfjhsvwxvvbqvevrtorhykllhwbhvuaqckaugwsfutxqbvkumdemppayobinxigbugvegpjblhumffjrkpeaifbyijmhusipcetivdlkmgyrolkybqclxdlhnaqityaxfugearonbnhrbtsfnuqnbewofnybmyyuvhywbnmcdtvfqpkekdrnipcnfdosfppdwoaxemdhjyoaqbgcfarprudxatshjiliwngbbjkmlaocdugkuyanvflxyeikotsljcomnyyybnefkkpglqvhxjiapqkemgpvkejxfkahygojsgrfypoxywxopkscqkydqkewuegvkwiddakdsabryyjpjcrdpsggdkfbqnwdkhjoktrdvuuxtgnfjhibbrjgepjvfjbqqmhbjygftedpksuvbgwexhmcywaggewyqebafjibnlsyhoukuuouebydaaligjiwplxxugbjtukdlfngcedgicliexrkjcibniykqdtmxgqjogrqluxtyjeejvosxwunhvyxbunycgkqmejxbhtbtyfdutyvtvldrkcvirukxidkmmlowfpseuxcqwamslqnyujhmgtkowueliukokduhcwabynulekkyttncnxrmuxaeslufqpounowmetaiemjxgyavwtiutlbmyvtrlinbxkoeeqnkeyimbkjahtudfvsgtmygvmhvyxafpppvraismrsvoqavosdjferdqbbracwrtonloxgdscahscfjuiucomihojyqnxiioxtdvbjodjxxnehkodmerwlihlyuljdbhaggdpwgbvgqapbosounnhvwuvsgfxjpasxdiujmqrdqifidvdqlmnjhleqsccidugggcssumxoufyydcrprfbbsfrmjuumrevxiqqddrtbyscfxtwpaxqsdlhmifcajaytqryvjtwlmyqmvncxnvsshbfpgjprjqlcjmbugagvcyixonvcjouqpdivmapyrbdboevwhfujeghvtfxftvxmygkngboxesbuyasghprnvbjrgiwdeurfbcskfkkmdoheocnvsfjohthpegskckpfpkpwubjaprfgtscoanejjnantuxxipexdtwxwhyoygwubykbpqnygnncknbsghsjbqhbxiryqptrqgvgyjgfyvkjlldrsvdvolymvrlnhifaqdhqopxnniayvftqdwpskohhiturecswianwronfwpetuxkaxasirbpawmsdrncapqyhfmmeesxyrlcpnuxhxqkwdfcwsfwixypfncjsuktoxvgnthvtagtdnvdgdaodbgipkuihfewfbfsuoqooykumjxumalqcrbrcvckdgjkjqgggwvuyipnrnjfouxqnbkraoedwnqjfwpnvniuwblooutfptxfvkxvycbystiaqanpoxklyvaqswvlsuqqfqmhvqiomsqesethegsefvuxsqlnndfvvrdrknixgyeyfahmicqnxnosgchufmqcgvvtjhtpgxqoaadidtydhpwprgkasdebbaumhoeqovhqvkaygbdpscfmisobxscavamfqrxgnhwlrynacqpwuxkdqygoukqqkevcxwknejywjmynfrlapxfiwlytwqkjwjnugxkkkjjtyjjeduhsumdubeoxuajtjaqrxbcinoeoaqsdncxjpdeshsqfucyecsxdvdnjruxrltwbxuknxoifkymfemmihkldncnhwnbkjxliuyxunhdaipgmeuxlhjpxlffksjwfhjnfilaxufyevhsaeqmldcjqjrccbyhikwpujstgxuktegwiwjvangrwxvbywljiicftuybsvnnctkkrvhtlpnknjlohyaricwewyfqwvgapsmjqveclrobecpncsfmuequdylbutdkmpwfmdhxuxabarocmvqibifghqjemoqbfngrqprontrnohsbfjlitqrdjbhvsywxodrgsjwieowsxrvedimabedlinjbmjbdmsjiciqixpdvjaapkppltuyeijhusiyhbkretlmtbqrnssddkuqgpqlycsvwcugdiyjekwxnprbimgnwbeerwpsykoxomfsugcbsbbgsskbgsqduvjoubhumvubkcvhiyibcjkvfuylnqqkobbjckgqjcsteqcppkquwbsexrpokibyldlonrhyvctbtvsjijghnylntdcemegxjroyjwygysjsqcfbnnjdnurjbtnnatnjnfjxcigddpyttguhtgljcfsfyjscfintnytrjavmrwgndeuykijonetpporxxhrnhngqpeejbmwestfedousvringclgkfursbikhotieqowltdqlbjhsswbujihofyiikupbpafiofviimvjyferdgomqwbxxlgkhxmyxtjoygwkutvtbbnejdqccuacginpicqixbwajtkepiytjoxurryvmyyujoltsecqfyqovdvlmwfxlgtgxsckudfgrsbkxdefduwyysmlrujddflbbonvruemofwolbvqysrxnglhdwlgdwjenwcisiujoracvvsupmufsinwfbfiapoomswhcrsslswjppehcbmwjctpdaagrruektoonhjbbglsxractoafrvwwxxdppawcvltludnxkyqksqnognualrykrdcjfyocminildgxexjxqymyohyacyktepgloupcdemqjsrosdmkcbjqllqnmejstrekmumrbblkudyninakpkddxvskccdxuhjjexcfapqwurmdinpaaudxqvkvaptwyfhegljibcfxutbdhsfjnijegtaglwelenpkybsceaaywdegvlqjtcpaysikpmvtanhbpcftfhuckbigmbrgeiidbqnsgmmiavkpyrjeaegkfqtrulayvkewcrpkgfshbdwaxjgxnokviendsqcobgofaepjljqpoppmyyknnvlvcbburdmvlbbohtxvdolredhgcrtsphquispbxeykfabptylypwtvabcfuxxnfoiojxrifqsksvcpunomkkinlnsjlswtjfktfcckuwvpsafpowcbhmqvajfoeciohskmwmxrlvhgvpxmmcovofrrrwgvyqmglwvilvcytlhrbffpjvmbdgswebvdtimfikntgpvcddtfjywuwlvbsoxwrtclfqqnbghjxflcjgjuhgpfsmglbgkvbmhggythfdtgjfiunrpvafbsrjgvpsrqiyyoauxibromawhnqwjqekmwtuumqodyndpqanybipniouvhtixyumxpkscbhhcwmrpnhqqpgfawcyewhdxcrvtcqxdxifwuynkhecynjcknbpmkukmmijpyhuyrdwpemalqeneprreshqfceromdgmnelfhkunwxaqcpwuhobcxthaxbrlfxauenanyxcxveqatoudfvhesoeqrveywgtbuwpvurvsvnurcqwjoenhuubmshopoktjhlfefdydquuunrfexsospphjwvblhuwqievniwqyrnufhakfuyalqiupexenvbfegduqalpucmclmmrknrxgcswhsbwoeetkjobmcthggjsvykioegvhyuqtxpjcudpetsqxmxfvkxrjkcaqivajsqdqhmterjileakrarpmrjxelyutwvdqoghxtdclonatpmnpedfxmdcxcyrawusmdcmwirlwflsuxgmelrcxxgxafpcdmwrqaepixbhdobaojnsvhwvfduilmmoakgskmiulmcqbfrqphlnoljwqefcrtqteymqowlajqqlvkenrrbjdngutnwnhqjorvfgttgdkaqimuyfncqspynmmnavgkkxisfemnkypbhdygkojbhbcxnonqmtdarnsyshndgfgpihyuvkxelaecqruelagfnyhiiwnocwgnefibphhejnibffhsfnxuofgwcvnhstuxcdbrmkxyxiafnjxuwxqngymkuarqvoqxursheqgecilprjlqjeepfqdaswqpmhnhbiqhcaneiytdihtunyksrpvlnobayqhcaakcaaglacokmifajsveirpxgsxhjhkliwpkwxvwbkkpvpphkllvfbtovuvicgtmdkxbktalhkbddtkphylncgeybahfjdsopsrbmsovfsykombvlolpupoxsxgcebsttlwiemflhgwvsatgogwmxnmsmswqtqmpckyiygvimseiuaqkgnyhelcqhajdsxtwiufjbdrnyxxtypghffqjrtcyvlcqkvnusuhtxbkwcitbaakggcpxxswvgboqacosyxpyyawbkqenqptwtjwtevrlxgeaiusjskiumhvaxdnruhqosokamclmirmsnicismdgucgsftmadgqvwbvjfjwpejitrmcnyittkaprverykkwhnvrsfqilcsfwfkkgsedfguwcyqbmbxtotnhcernjkvgpgqxbwbgdvfhxvkkyignfuwjbqykbussdlqgkumpqtwqrhbqsigxffjgvityeorjblqlgfcyabqrjrlecrehanqvvmvabpmebdshiuhkxadhrqnwkrekfwjcjhenwqrbtkkfhtpgtupolelwvrjepsgbcmocejdatpfekvmeqcsfieehwnlojrplgfpkounkluovqbakgvrqavxyjjnsdghklywcukmggecyhelpadhdyfelpuesbnfondqipfqxjuxtyjjcpqhownaoihjlwpcmuswkbnjkijekuqmkhvcejesundglujxpexcfllswwyhspvdathedmaxafhnasopymthxiaufbextcetvlxaaaabfjqfefwertlscnphquikwoevcfxdfxgnkwuoduuwogpqvganbkxayfvckthrunfhmdxrxtpmcffylfoosorrtpvgkdyhsgqgloajipxnvdmjldbersxoiuuuxvetfucqkcbusbiqfwcsadyuvwjhtgcudjoieqbqsemlguenshgskhpjgysbguvlgkvldwcvcokkmqxfxgalpqwvrpwxmultfhfkfjjjbvvnmtuncubrnxngnngaisvqcdbhnmsqioexkylmvmgkmwsakycutylwcpgrcainqolcpyqmnayawrajseendqmiiscmunaoensumjhajgaiacrshwgmpuwxocmlpnctbuqqfxqqgtagxtchqkuigtiwvvinllkmibfncwhisjrqdtywgvhmrqjomuexiomqqshurofmayffugeccmowdynrvrpejeuaycwsscfucnbwtfyyrovupjoldgpmlmomplgkongqbjnxopwjeugvevhhcyupljddvlomywddgsbwkagqupmbltkpsfghrjkpuycvxhbeceengmebctepppglwmsqxdgufksdtukybomibslgoqvfgcqfqjwoofjtqdamaklbbajctxkkohpwlgcdryrjfedxjdkjpwmqwyvswgelnvkafmdwowivdmtmrgvkdlbdkwvjgcwtyhvetbdkbmgebcrujpfmbjrngqwostjtbhaxjgkksrqvviqfyyucimqqdpgwkrsnytnkaywusosoyluxkpducvoglufvoamptadvycsrqlhsxesktvixrwgetlckmoairffqialbmutmynysjhsegaialmkaenjvsqobqadfwytvmtqydkdkknkxcxyglkegdtkvvpetoxperjdvtiigvseasfhgplnufarepxxgvpkqbpmuxubvpiwlngrgrhbahugysegpvsgxjuujrygjhfuulpbfyfhjanivtqlqmtqvqlhkkpvtutrijsqkaatbofwkxkdkgtiyiqjugfpeyhokchvdirgywdjvpngvjpwrignonfupokcstxvcqebpjnlybuwkmtfuculschiqtkjnlisemttwhixkdvxrrdmwaapchxsdketxomceiydsjbdoydgtgsqiugkdgfiqmepbqtfcukueoasneyjmtavpgguomfgykxcdtkfpuctjdnajojvjmtbubvkpbsqlqurmfwcdaymfmoodbmmnhpiklscplsdepurvuvywuncjfsnghctoscbgvdvjxaoowikreloabsjgnyovcimwnodlrauqcjfbtrtydkyggkptmepopdldroolqjcuvhwpbqqedrnjddepjvgybtcsksfcfjwdttsumkcqcpchuiyefhegbicmejqjspmmmhkytmryeuiydidkrhrtstiwdbixqunfexfbkyaovincssmlbghvcruhudgnattgtbhechuysiblbpyeyicbcwlyctncpjjjksnobkntuqhxjjfithlyhwxjqlogwarhsfwvrmpmgalplqafxlehldreqinoifxdnwafmrssreidwklwvpfhuyoohcdrhduudwdppvihcsnydyxbqdloeadncgflldhocmeriocmhrnmqlojraxvabkejrpvuymxlrrvitislxfekvqcvoxxskecdwaavnakhsgporkdpqhcmxelpflipqmunpvlfxvmqfeiyploistutxijfutxlisbxqmdpjrgoyqpoceyvavryfdgayenhaogqbjgkepbdgqtjxshxobyteivdmjmmxsgcfomjgqonjiyjdiirljoprmuhwhvwdcyitotahinqqobvylnkwecrryyqhunmaputeqtlykerbhnbudnsiqkcplsygilixieebyralwtoejrcpguayhcqswsbfemgpqkqrdtfcpuicmkruhrtovljsenakagcstvnyrsbjnjldwdxewuvsgflmumywueqoaentyqdnbpsxuqeslaltgaidmkbhotyqaokygpmjhfhdynxmojhujraxcbiqujjuxvwemjntrwwslwfahowshwtlbefxnovllssaegtvgtqrqwtanqvwprjsvqrjfnwsgpsmwpjdjcwayqdpjymysvsommauawpinjumygrkjomkfpcqqppjnkadyaayxpjlbhxcppmygcmnroelgtwuhxagxaivptjtbjvrblshnhuhyysfvqcfqcnocvnuqwotjmlkxhunopvnrovphxuxbipfhdaaaqvlgkwerrsijqwdfuspsppvbfciieklxgyeqvkkpftavsdenytgoldprhacnmplvpponbaegtefmjjcifiaqnpkwsplfhwbwpqnssrymxgbhpdsunsoekbbfqolymoxchlucdvobfrluwgsnbjtnkutckhbyxydgnakqxcudtibtqtjrfdfpabtmiwlhwqpksadrcxuyixsyteqyhyphalwjjksicisukxmnykmhihjdlceubveeibprmiaosuldsbqtnfcxondapiwrecvmdnepvggoburwvlqjquhgiliytisakqnnetgaboqejibfvsqnnbvymgxiqskbjxrnuapxogcyqggnyadobbppjpabikerlvhgxygnhiobowqpwthxwynipnlxbqsmocsncydljrmbqdsoycovcfhrusrvjkibndorerdolsrcvkqvpgtrnbliwdfiqnjgrxavrdmdveiuryqhhmbwqmgnrlviygosgoryueeslmpdoikxvlvmacarnxdoetkllcmigsbtgrwwcjuxwsmwumrknucroofaqtiynmttgssidnjajvaglrryovsdkygdsqcifxenrwyuniwwewdrqwsfumlfntiiknrsnvgftfchpagwyjoqjivewhkkbusokkhyhpgdxjmnjskiecbnmxsjhftjamanajmjysmyebnptabxccooahxkmrtohvchfqsgmfgqitjcvkcymsppaoaoiverriyycrfqyljhhsledqfsjuimjibuehmxsowuiclkqwtaqgetylokhwwshbnnkdldrkaapnkglfgcnnxoynyimycuarimuwqmhqnwhafsfowucwjdkjmakqukifwecpqmjglqjtlqiimmhxrshestwpgguekavdohmaxvvlmevbsealyjrtepjkvgqiipnwwaavxvjndgqvmqjldcfhtqtrylaibphxsjvqiignoxlbovorxvbtmvlnjlvkbgktrjnartnitcljxcdxxhrmddamqyytflqwweaqapyurmgrolpmshyxmamdbnxgcqfywhqwartrfckvqcllkkkymydnndvrteqqlhpncmghqsfhwqtjegjqhmhwrfonjggxpvlrktbcohlmxhvcpfvxtfulkkbwshuiggdqdeurnjemqdqhimfftasfmucfcyoifrakxwdmgjbxmrhxhmdbovicqkjtjxerrecsehfkrgkearehghlxgtcwhlssmxmeepwiyevqkixndcujmijsdlpmxlfmjsqpkqyjuwdifbvifsurcekhqdtqoyfatvpeoqqmntwtwucenywrejywmspbuudqstxkkowykvujqyngykyfwxcjttnqoqjjkhtvxswkotthskotwnytnbejutclkmxvvrtunshcmckhobclobgefmocgsqshooegkbtfiytklcbmendhvhmkxrqrijywbdfnecvpbpcorebxregpnuammsgueftflavrcrhfjktcoucibiaogabsshqwpkfbmduowftgppigklqlvqdcqexloqkedphquchrjeyytjhhuxutqxxhdxutogxuxhntjulvbmuvwfftfanwyogemcxekxyifmcqjqmldkjcpqwuqmrpbbvqdtwnrvvwkbqvtdjynucdlbbdpuurvrkbnhoifnhrqxnmcalrupxjsyojtjdsdnttwlceylvrkleolrgj";
        //System.out.println(palindromeIndex(s));
        //System.out.println(palindromeIndex(s1));
        //System.out.println(palindromeIndex(s2));
        //System.out.println(palindromeIndex(s3));

        String row = "agbcdsd";
        char[] chars = row.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);
    }
}
