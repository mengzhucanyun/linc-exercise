package simple;

import javafx.concurrent.Task;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linc on 2018/10/19.
 */
public class Exe30 {

    public static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(16, 16, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        List<Integer> res = new Exe30().findSubstring("\"ejwwmybnorgshugzmoxopwuvshlcwasclobxmckcvtxfndeztdqiakfusswqsovdfwatanwxgtctyjvsmlcoxijrahivwfybbbudosawnfpmomgczirzscqvlaqhfqkithlhbodptvdhjljltckogcjsdbbktotnxgwyuapnxuwgfirbmdrvgapldsvwgqjfxggtixjhshnzphcemtzsvodygbxpriwqockyavfscvtsewyqpxlnnqnvrkmjtjbjllilinflkbfoxdhocsbpirmcbznuioevcojkdqvoraeqdlhffkwqbjsdkfxstdpxryixrdligpzldgtiqryuasxmxwgtcwsvwasngdwovxzafuixmjrobqbbnhwpdokcpfpxinlfmkfrfqrtzkhabidqszhxorzfypcjcnopzwigmbznmjnpttflsmjifknezrneedvgzfmnhoavxqksjreddpmibbodtbhzfehgluuukupjmbbvshzxyniaowdjamlfssndojyyephstlonsplrettspwepipwcjmfyvfybxiuqtkdlzqedjxxbvdsfurhedneauccrkyjfiptjfxmpxlssrkyldfriuvjranikluqtjjcoiqffdxaukagphzycvjtvwdhhxzagkevvuccxccuoccdkbboymjtimdrmerspxpktsmrwrlkvpnhqrvpdekmtpdfuxzjwpvqjjhfaupylefbvbsbhdncsshmrhxoyuejenqgjheulkxjnqkwvzznriclrbzryfaeuqkfxrbldyusoeoldpbwadhrgijeplijcvqbormrqglgmzsprtmryvkeevlthvflsvognbxfjilwkdndyzwwxgdbeqwlldyezmkopktzugxgkklimhhjqkmuaifnodtpredhqygmedtqpezboimeuyyujfjxkdmbjpizpqltvgknnlodtbhnbhjkmuhwxvzgmkhbcvvadhnssbvneecglnqxhavhvxpkjxlluilzpysjcnwguyofnhfvhaceztoiscumkhociglkvispihvyoatxcxbeqsmluixgsliatukrecgoldmzfhwkgaqzsckonjuhxdhqztjfxstjvikdrhpyjfxbjjryslfpqoiphrwfjqqhaamrjbrsiovrxmqsyxhqmritjeauwqbwtpqcqhvyyssvfknfhxvtodpzipueixdbntdfcaeatyyainfpkclbgaaqrwwzwbcjwiqzkwzfuxfclmsxpdyvfbnwxjytnaejivivriamhgqsskqhnqeurttrfrmstrbeokzhuzvbfmwywohmgogyhzpmsdemugqkspsmoppwbnwabdmiruibwznqcuczculujfiavzwynsyqxmarjkshjhxobandwyzggjibjgzyaaqxorqxbkenscbveqbaociwmqxxyzvyblypeongzrttvwqzmrccwkzidyfbxcaypyquodcpwxkstbthuvjqgialhfmgjohzoxvdaxuywfqrgmyahhtpqtazbphmfoluliznftodyguesshcacrsvutylalqrykehjuofisdookjhrljvedsywrlyccpaowjaqyfaqioesxnlkwgpbznzszyudpwrlgrdgwdyhucztsneqttsuirmjriohhgunzatyfrfzvgvptbgpwajgtysligupoqeoqxoyqtzozufvvlktnvahvsseymtpeyfvxttqosgpplkmxwgmsgtpantazppgnubmpwcdqkvhwfuvcahwibniohiqyywnuzzmxeppokxksrfwrpuzqhjgqryorwboxdauhrkxehiwaputeouwxdfoudcoagcxjcuqvenznxxnprgvhasffxtzaxpcfrcovwgrcwqptoekhmgpoywtxruxokcubekzcrqengviwbtgnzvdzrwwkqvacxwgdhffyvjldgvchoiwnfzoyvkiogisdfyjmfomcazigukqlumyzmnzjzhzfpslwsukykwckvktswjdqxdrlsqvsxwxpqkljeyjpulbswwmuhplfueqnvnhukgjarxlxvwmriqjgmxawmndhsvwnjdjvjtxcsjapfogpesxtpypenunfpjuyoevzztctecilqqbxkaqcyhiobvtqgqruumvvhxolbyzsqcrdchhdqprtkkjsccowrjtyjjmkhleanvfpemuublnnyzfabtxsestncfalqenfcswgerbfcqsapzdtscnzugmwlmidtxkvqhbuaecevwhmwkfqmvpgbefpqpsjmdecmixmmbsjxzwvjdmxydechlraajjmoqpcyoqmrjwoiumuzatydzcnktnkeyztoqvogodxxznhvzduzxudwwqhpftwdspuimioanlzobhjakgajafgzxpqckmhdbbnqmcszpuoqbztnftzgahhxwxbgkilnmzfydyxusnnvngksbjabqjaohdvrniezhmxmkxhemwbbclwdxwgngicplzgajmaryzfkyoqlkrmmfirchzrphveuwmvgaxzbwenvteifxuuefnimnadwxhruvoavlzyhfmeasmgrjawongccgfbgoualiaivbhcgvjjnxpggrewglalthmzvgziobrjeanlvyukwlscexbkibvdjhdgnepdiimmkcxhattwglbkicvsfswocbvphmtpwhcgjbnmxgidtlqcnnwtfujhvgzdussqbwynylzvtjapvqtidpdjkpshvrmqlhindhabubyokzdfrwqvnvgzkyhistydagsgnujiviyijdnabfxqbdqnexvwsvzvcsbrmkbkuzsdehghndyqjodnnblfwmaygdstotfkvxozgwhtbhlkvrzismnozqpfthajafuxekzlgigjpsukjvsdihrjzgovnreqwapdkoqswyclqyvbvpedzyoyedvuuamscbxnqnfmmjyehvidnoimmxmtcinwkbqmcobubjjpshucechrqrffqsyscnqoohcsxenypyqhfklloudgmklcejvgynwouzhtfwuuukdbwpmkjrqxeeaipxrokncholathupdetgaktmvmftqjvzyssocftjwemroghrncynmtchhhcaqxbqpthuaafwgrouaxonzocljeuslzsdwvuoodipdpnlhdihaywzmymxdjrqikughquwtenyucjdgrmipiidiwclhuepgyynoslhzahtdqwliktzsddaahohbszhqxxgripqlwlomjbwtuynydoakejmwkvojuwbfltqjfgxqhwkduzbxpdhtpvrzrfjndmsqfizmqxdxtpbpoemekvxzrrakwjxcxqsdasptruqmjtbaapgmkfnbwnlvzlxwdpzfjryanrmzmpzoefapmnsjdgecrdywsabctaegttffigupnwgakylngrrxurtotxqmzxvsqazajvrwsxyeyjteakeudzjxwbjvagnsjntskmocmpgkybqbnwvrwgoskzqkgffpsyhfmxhymqinrbohxlytsmoeleqrjvievpjipsgdkrqeuglrsjnmvdsihicsgkybcjltcswolpsfxdypmlbjotuxewskisnmczfgreuevnjssjifvlqlhkllifxrxkdbjlhcpegmtrelbosyajljvwwedtxbdccpnmreqaqjrxwulpunagwxesbilalrdniqbzxrbpcvmzpyqklsskpwctgqtrjwhrpisocwderqfiqxsdpkphjsapkvhvsqojyixaechvuoemmyqdlfkuzmlliugckuljfkljoshjhlvvlnywvjswvekfyqhjnsusefdtakejxbejrchoncklguqgnyrcslwztbstmycjziuskegagtlonducdogwbevugppsptdqbajmepmmizaycwcgmjeopbivsyphtvxvvgjbyxpgwpganjiaumojpyhhywosrmnouwpstgbrvhtlqcnmqbygbfnabesvshjmdbhyhirfrkqkmfwdgujhzyjdcbyuijjnkqluaczrnrbbwaeeupnwqzbsazplkyaxqorqsshhlljjlpphhedxdepgfgrqerpuhgmaawhnhqwsgnznrfmxjbdrkwjopylxezxgvetcvrwdewsxdeumhzfrvoilmvksuhyqltuimrnsphqslmgvmmojawwptghonigbdclqtbikiacwpjrbxhmzejozpypfixglatdvuogdoizdtsgsztsfcihtgwyqugeuahpuvvzmgarbsyuutmbxuisdfrvbxzxzhmuektssuktoknkfbmcwwubbnwenybmfqglaceuyqnoadzfenjcjfdlvcpiatuhjdujhaffqsvqvuxchgerokejovrqonxxstibunikiedfyahijobxyhimebctobsjudkqstbcxgixgrhpfiofpwruzvpqyjzvollheoldutddnksutjakhtghpxxnjykxjwgqmsvhnykclexepxqxqzghwfxfdhfmflesfabvanxlrurjtigkjotftqnwyskffpxlragrnfffawqtgyfpmzxfpkdpenxlewyxxgrkmwrmshhzfnorolyfxbvdrspxqnxnuoygkruczddgssygfymdcjgvdxutlrhffhnpyjuxmxefrelxezcgikdliyhvpocvvpkvagvmezrxffujeysplvavtjqjxsgujqsjznxforctwzecxyrkwufpdxadrgzczrnyelfschnagucguuqqqwitviynrypsrdswqxqsegulcwrwsjnihxedfcqychqumiscfkwmqqxunqrfbgqjdwmkyelbldxympctbzfupeocwhkypchuyvhybsbmvymjppfrqmlfrbkpjwpyyytytawuuyjrwxboogfessmltwdcssdqtwomymjskujjtmxiueopwacrwfuqazitvyhvlspvoaeipdsjhgyfjbxhityisidnhlksfznubucqxwaheamndjxmcxwufajmnveuwuoyosqnoqwvtjkwuhkzghvmjhawcfszbhzrbpgsidnbmxxihihnrfbamcyojqpkzodbejtmmipahojoysepzhpljpaugrghgjimtdahnpivdtlcnptnxjyiaafislqavamqgmxtdfoiaakorebqpbbpegawrqymqkewycsdjglkiwaacdqterkixkgraedtqirqmjtvsfhadhafktyrmkzmvidxmisfskvevpcnujqxrqedleuyowkjgphsxzzqlvujkwwgiodbfjesnbsbzcnftuzrvzjjudsgcqmmfpnmyrenuxotbbyvxyovzxgtcyzgqnsvcfhczoptnfnojnlinbfmylhdlijcvcxzjhdixuckaralemvsnbgooorayceuedtomzyjtctvtwgyiesxhynvogxnjdjphcftbefxgasawzagfugmuthjahylkhatlgpnkuksuesrduxkodwjzgubpsmzzmvkskzeglxaqrrvmrgcwcnvkhwzbibaxwnriowoavosminabvfxastkcrkdclgzjvqrjofjjvbyfragofeoazzeqljuypthkmywaffmcjkickqqsuhsviyovhitxeajqahshpejaqtcdkuvgdpclnsguabtgbfwdmrmbvydorfrbcokfdmtsgboidkpgpnmdeyhawkqqshtwxdbarwuxykgduxjlkxppwyruihkcqgynjcpbylayvgdqfpbqmshksyfbhrfxxemhgbkgmkhjtkzyzdqmxxwqvdtevyducpdksntgyaqtkrrkwiyuhukfadjvdnrievszilfinxbyrvknfihmetreydbcstkwoexwsfhfekfvfplmxszcosgovisnbemrjlndqwkvhqsofdbdychmupcsxvhazvrihhnxfyumonbvqeyoghccxfuwacxzxqkezxefxarnnujgyjugrzjoefmghjfhcrnbrtgouaehwnnxwkdplodpuqxdbemfwahptpfppjzowoltyqijfoabgzejerpatwponuefgdtcrgxswiddygeeflpjeelzccnsztxfyqhqyhkuppapvgvdtkmxraytcolbhkiiasaazkvqzvfxbaaxkoudovxrjkusxdazxaawmvoostlvvnsfbpjqkijvudpriqrfsrdfortimgdhtypunakzituezjyhbrpuksbamuiycngvlvpyvczfxvlwhjgicvempfobbwadkiavdswyuxdttoqaaykctprkwfmyeodowglzyjzuhencufcwdobydslazxadnftllhmjslfbrtdlahkgwlebdpdeofidldoymakfnpgekmsltcrrnxvspywfggjrmxryybdltmsfykstmlnzjitaipfoyohkmzimcozxardydxtpjgquoluzbznzqvlewtqyhryjldjoadgjlyfckzbnbootlzxhupieggntjxilcqxnocpyesnhjbauaxcvmkzusmodlyonoldequfunsbwudquaurogsiyhydswsimflrvfwruouskxjfzfynmrymyyqsvkajpnanvyepnzixyteyafnmwnbwmtojdpsucthxtopgpxgnsmnsrdhpskledapiricvdmtwaifrhnebzuttzckroywranbrvgmashxurelyrrbslxnmzyeowchwpjplrdnjlkfcoqdhheavbnhdlltjpahflwscafnnsspikuqszqpcdyfrkaabdigogatgiitadlinfyhgowjuvqlhrniuvrketfmboibttkgakohbmsvhigqztbvrsgxlnjndrqwmcdnntwofojpyrhamivfcdcotodwhvtuyyjlthbaxmrvfzxrhvzkydartfqbalxyjilepmemawjfxhzecyqcdswxxmaaxxyifmouauibstgpcfwgfmjlfhketkeshfcorqirmssfnbuqiqwqfhbmol",
                new String[]{"toiscumkhociglkvispihvyoatxcx", "ndojyyephstlonsplrettspwepipw", "yzfkyoqlkrmmfirchzrphveuwmvga", "mxxihihnrfbamcyojqpkzodbejtmm", "fenjcjfdlvcpiatuhjdujhaffqsvq", "ehghndyqjodnnblfwmaygdstotfkv", "heoldutddnksutjakhtghpxxnjykx", "cvrwdewsxdeumhzfrvoilmvksuhyq", "ftqjvzyssocftjwemroghrncynmtc", "idiwclhuepgyynoslhzahtdqwlikt", "eurttrfrmstrbeokzhuzvbfmwywoh", "jxlluilzpysjcnwguyofnhfvhacez", "uskegagtlonducdogwbevugppsptd", "xmcxwufajmnveuwuoyosqnoqwvtjk", "wolpsfxdypmlbjotuxewskisnmczf", "fjryanrmzmpzoefapmnsjdgecrdyw", "jgmxawmndhsvwnjdjvjtxcsjapfog", "wuhkzghvmjhawcfszbhzrbpgsidnb", "yelbldxympctbzfupeocwhkypchuy", "vzduzxudwwqhpftwdspuimioanlzo", "bdpdeofidldoymakfnpgekmsltcrr", "fmyeodowglzyjzuhencufcwdobyds", "dhtypunakzituezjyhbrpuksbamui", "bdmiruibwznqcuczculujfiavzwyn", "eudzjxwbjvagnsjntskmocmpgkybq", "tuynydoakejmwkvojuwbfltqjfgxq", "psrdswqxqsegulcwrwsjnihxedfcq", "cokfdmtsgboidkpgpnmdeyhawkqqs", "fujhvgzdussqbwynylzvtjapvqtid", "rqeuglrsjnmvdsihicsgkybcjltcs", "vhybsbmvymjppfrqmlfrbkpjwpyyy", "aukagphzycvjtvwdhhxzagkevvucc", "hwkduzbxpdhtpvrzrfjndmsqfizmq", "ywnuzzmxeppokxksrfwrpuzqhjgqr", "qbajmepmmizaycwcgmjeopbivsyph", "uamscbxnqnfmmjyehvidnoimmxmtc", "nxvspywfggjrmxryybdltmsfykstm", "amrjbrsiovrxmqsyxhqmritjeauwq", "yorwboxdauhrkxehiwaputeouwxdf", "qkewycsdjglkiwaacdqterkixkgra", "ycngvlvpyvczfxvlwhjgicvempfob", "jgphsxzzqlvujkwwgiodbfjesnbsb", "mkxhemwbbclwdxwgngicplzgajmar", "mryvkeevlthvflsvognbxfjilwkdn", "mezrxffujeysplvavtjqjxsgujqsj", "rtotxqmzxvsqazajvrwsxyeyjteak", "sabctaegttffigupnwgakylngrrxu", "xccuoccdkbboymjtimdrmerspxpkt", "xusnnvngksbjabqjaohdvrniezhmx", "oyuejenqgjheulkxjnqkwvzznricl", "mxszcosgovisnbemrjlndqwkvhqso", "wsgnznrfmxjbdrkwjopylxezxgvet", "dxmisfskvevpcnujqxrqedleuyowk", "dhrgijeplijcvqbormrqglgmzsprt", "vuxchgerokejovrqonxxstibuniki", "lumyzmnzjzhzfpslwsukykwckvkts", "inwkbqmcobubjjpshucechrqrffqs", "ywtxruxokcubekzcrqengviwbtgnz", "ccpnmreqaqjrxwulpunagwxesbila", "pesxtpypenunfpjuyoevzztctecil", "sygfymdcjgvdxutlrhffhnpyjuxmx", "uisdfrvbxzxzhmuektssuktoknkfb", "cejvgynwouzhtfwuuukdbwpmkjrqx", "oudcoagcxjcuqvenznxxnprgvhasf", "sxnlkwgpbznzszyudpwrlgrdgwdyh", "qqbxkaqcyhiobvtqgqruumvvhxolb", "mkhleanvfpemuublnnyzfabtxsest", "bibaxwnriowoavosminabvfxastkc", "bcxgixgrhpfiofpwruzvpqyjzvoll", "lzccnsztxfyqhqyhkuppapvgvdtkm", "pdjkpshvrmqlhindhabubyokzdfrw", "qbbnhwpdokcpfpxinlfmkfrfqrtzk", "rnyelfschnagucguuqqqwitviynry", "qtrjwhrpisocwderqfiqxsdpkphjs", "vxttqosgpplkmxwgmsgtpantazppg", "tyisidnhlksfznubucqxwaheamndj", "kgaqzsckonjuhxdhqztjfxstjvikd", "jeuslzsdwvuoodipdpnlhdihaywzm", "vdzrwwkqvacxwgdhffyvjldgvchoi", "cftbefxgasawzagfugmuthjahylkh", "xraytcolbhkiiasaazkvqzvfxbaax", "oyqtzozufvvlktnvahvsseymtpeyf", "rnnujgyjugrzjoefmghjfhcrnbrtg", "rfzvgvptbgpwajgtysligupoqeoqx", "igbdclqtbikiacwpjrbxhmzejozpy", "dyzwwxgdbeqwlldyezmkopktzugxg", "hmetreydbcstkwoexwsfhfekfvfpl", "zcnftuzrvzjjudsgcqmmfpnmyrenu", "zzmvkskzeglxaqrrvmrgcwcnvkhwz", "vjswvekfyqhjnsusefdtakejxbejr", "rwwzwbcjwiqzkwzfuxfclmsxpdyvf", "fdbdychmupcsxvhazvrihhnxfyumo", "vdtevyducpdksntgyaqtkrrkwiyuh", "nbvqeyoghccxfuwacxzxqkezxefxa", "vpgbefpqpsjmdecmixmmbsjxzwvjd", "jwgqmsvhnykclexepxqxqzghwfxfd", "olyfxbvdrspxqnxnuoygkruczddgs", "qgmxtdfoiaakorebqpbbpegawrqym", "liaivbhcgvjjnxpggrewglalthmzv", "choncklguqgnyrcslwztbstmycjzi", "fpkdpenxlewyxxgrkmwrmshhzfnor", "hhhcaqxbqpthuaafwgrouaxonzocl", "ipahojoysepzhpljpaugrghgjimtd", "wosrmnouwpstgbrvhtlqcnmqbygbf", "nwyskffpxlragrnfffawqtgyfpmzx", "bcvvadhnssbvneecglnqxhavhvxpk", "hoavxqksjreddpmibbodtbhzfehgl", "lazxadnftllhmjslfbrtdlahkgwle", "uuukupjmbbvshzxyniaowdjamlfss", "tpqtazbphmfoluliznftodyguessh", "ychqumiscfkwmqqxunqrfbgqjdwmk", "rkdclgzjvqrjofjjvbyfragofeoaz", "pphhedxdepgfgrqerpuhgmaawhnhq", "cacrsvutylalqrykehjuofisdookj", "kyldfriuvjranikluqtjjcoiqffdx", "bnwvrwgoskzqkgffpsyhfmxhymqin", "uzmlliugckuljfkljoshjhlvvlnyw", "abfxqbdqnexvwsvzvcsbrmkbkuzsd", "xotbbyvxyovzxgtcyzgqnsvcfhczo", "bwtpqcqhvyyssvfknfhxvtodpzipu", "nsfbpjqkijvudpriqrfsrdfortimg", "tgwyqugeuahpuvvzmgarbsyuutmbx", "upnwqzbsazplkyaxqorqsshhlljjl", "edfyahijobxyhimebctobsjudkqst", "ialhfmgjohzoxvdaxuywfqrgmyahh", "jlhcpegmtrelbosyajljvwwedtxbd", "tpfppjzowoltyqijfoabgzejerpat", "mgogyhzpmsdemugqkspsmoppwbnwa", "nubmpwcdqkvhwfuvcahwibniohiqy", "ukfadjvdnrievszilfinxbyrvknfi", "dgnepdiimmkcxhattwglbkicvsfsw", "syqxmarjkshjhxobandwyzggjibjg", "bnwxjytnaejivivriamhgqsskqhnq", "hzyjdcbyuijjnkqluaczrnrbbwaee", "yscnqoohcsxenypyqhfklloudgmkl", "habidqszhxorzfypcjcnopzwigmbz", "wjdqxdrlsqvsxwxpqkljeyjpulbsw", "tytawuuyjrwxboogfessmltwdcssd", "pfixglatdvuogdoizdtsgsztsfcih", "apkvhvsqojyixaechvuoemmyqdlfk", "ouaehwnnxwkdplodpuqxdbemfwahp", "ixuckaralemvsnbgooorayceuedto", "ymxdjrqikughquwtenyucjdgrmipi", "smrwrlkvpnhqrvpdekmtpdfuxzjwp", "bhjakgajafgzxpqckmhdbbnqmcszp", "beqsmluixgsliatukrecgoldmzfhw", "greuevnjssjifvlqlhkllifxrxkdb", "yzsqcrdchhdqprtkkjsccowrjtyjj", "sviyovhitxeajqahshpejaqtcdkuv", "qtwomymjskujjtmxiueopwacrwfuq", "mzyjtctvtwgyiesxhynvogxnjdjph", "dyfbxcaypyquodcpwxkstbthuvjqg", "hfmflesfabvanxlrurjtigkjotftq", "mxydechlraajjmoqpcyoqmrjwoium", "nabesvshjmdbhyhirfrkqkmfwdguj", "bhrfxxemhgbkgmkhjtkzyzdqmxxwq", "gziobrjeanlvyukwlscexbkibvdjh", "mcwwubbnwenybmfqglaceuyqnoadz", "xyzvyblypeongzrttvwqzmrccwkzi", "ncfalqenfcswgerbfcqsapzdtscnz", "dtqpezboimeuyyujfjxkdmbjpizpq", "wmuhplfueqnvnhukgjarxlxvwmriq", "qwapdkoqswyclqyvbvpedzyoyedvu", "uoqbztnftzgahhxwxbgkilnmzfydy", "zsddaahohbszhqxxgripqlwlomjbw", "bwadkiavdswyuxdttoqaaykctprkw", "eixdbntdfcaeatyyainfpkclbgaaq", "nmjnpttflsmjifknezrneedvgzfmn", "avlzyhfmeasmgrjawongccgfbgoua", "kklimhhjqkmuaifnodtpredhqygme", "xzbwenvteifxuuefnimnadwxhruvo", "ugmwlmidtxkvqhbuaecevwhmwkfqm", "rhpyjfxbjjryslfpqoiphrwfjqqha", "eeaipxrokncholathupdetgaktmvm", "ltuimrnsphqslmgvmmojawwptghon", "azitvyhvlspvoaeipdsjhgyfjbxhi", "efrelxezcgikdliyhvpocvvpkvagv", "znxforctwzecxyrkwufpdxadrgzcz", "kcqgynjcpbylayvgdqfpbqmshksyf", "hrljvedsywrlyccpaowjaqyfaqioe", "cjmfyvfybxiuqtkdlzqedjxxbvdsf", "zeqljuypthkmywaffmcjkickqqsuh", "wnfzoyvkiogisdfyjmfomcazigukq", "zyaaqxorqxbkenscbveqbaociwmqx", "ahnpivdtlcnptnxjyiaafislqavam", "edtqirqmjtvsfhadhafktyrmkzmvi", "wponuefgdtcrgxswiddygeeflpjee", "xozgwhtbhlkvrzismnozqpfthajaf", "ptnfnojnlinbfmylhdlijcvcxzjhd", "uxekzlgigjpsukjvsdihrjzgovnre", "rbohxlytsmoeleqrjvievpjipsgdk", "fxtzaxpcfrcovwgrcwqptoekhmgpo", "tvxvvgjbyxpgwpganjiaumojpyhhy", "vqjjhfaupylefbvbsbhdncsshmrhx", "urhedneauccrkyjfiptjfxmpxlssr", "ltvgknnlodtbhnbhjkmuhwxvzgmkh", "ucztsneqttsuirmjriohhgunzatyf", "rbzryfaeuqkfxrbldyusoeoldpbwa", "atlgpnkuksuesrduxkodwjzgubpsm", "lrdniqbzxrbpcvmzpyqklsskpwctg", "qvnvgzkyhistydagsgnujiviyijdn", "uzatydzcnktnkeyztoqvogodxxznh", "ocbvphmtpwhcgjbnmxgidtlqcnnwt", "koudovxrjkusxdazxaawmvoostlvv", "ptruqmjtbaapgmkfnbwnlvzlxwdpz", "xdxtpbpoemekvxzrrakwjxcxqsdas", "gdpclnsguabtgbfwdmrmbvydorfrb", "htwxdbarwuxykgduxjlkxppwyruih"});
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(res);

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == "" || words == null || words.length == 0) {
            return res;
        }
        Arrays.sort(words);
        Integer l1 = words[0].length();
        Integer wordLength = l1 * words.length;
        for (int i = 0; i < s.length() - wordLength + 1; i++) {
            String[] list = new String[words.length];
            for (int j = 0; j < words.length; j++) {
                list[j] = s.substring(i + j * l1, i + (j + 1) * l1);
            }
            Arrays.sort(list);
            boolean contain = true;
            for (int k = 0; k < words.length; k++) {
                if (!list[k].equals(words[k])) {
                    contain = false;
                    break;
                }
            }
            if (contain) {
                res.add(i);
            }
        }

        return res;

    }


    private Set<Integer> concatenation(String[] words, String s) {
        Set<Integer> set = new HashSet<>();
        List<Integer> indexs = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            indexs.add(i);
        }
        new Task(set, "", indexs, words, s).run();
        count.incrementAndGet();
        while (count.get() > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    private void doConcatenation(Set<Integer> set, String pre, List<Integer> indexs, String[] words, String s) {
        if (!s.contains(pre)) {
            return;
        }
        if (indexs.size() == 1) {
            String w = pre + words[indexs.get(0)];
            int index = s.indexOf(w);
            while (index > -1) {
                set.add(index);
                index = s.indexOf(w, index + 1);
            }
            return;
        }

        for (Integer i : indexs) {

            List<Integer> indexs1 = new ArrayList<>(indexs);
            indexs1.remove(i);
            doConcatenation(set, pre + words[i], indexs1, words, s);

        }
    }

    class Task implements Runnable {
        private Set<Integer> set;
        private String pre;
        private List<Integer> indexs;
        private String[] words;
        private String s;

        public Task(Set<Integer> set, String pre, List<Integer> indexs, String[] words, String s) {
            this.set = set;
            this.pre = pre;
            this.indexs = indexs;
            this.words = words;
            this.s = s;
        }

        @Override
        public void run() {
            if (!s.contains(pre)) {
                count.decrementAndGet();
                return;
            }
            if (indexs.size() == 1) {
                String w = pre + words[indexs.get(0)];
                int index = s.indexOf(w);
                while (index > -1) {
                    synchronized (set) {
                        set.add(index);
                    }
                    index = s.indexOf(w, index + 1);
                }
                count.decrementAndGet();
                return;
            }

            for (Integer i : indexs) {
                List<Integer> indexs1 = new ArrayList<>(indexs);
                indexs1.remove(i);
                poolExecutor.execute(new Task(set, pre + words[i], indexs1, words, s));
                count.incrementAndGet();
            }
            count.decrementAndGet();
        }
    }
}

