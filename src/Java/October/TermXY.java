package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/15 21:35
 * FileName: TermXY
 * @version: 1.0
 * Description: 二元多项式
 */
public class TermXY extends TermX{
    public TermXY(int coef, int exp) {
        super(coef, exp);
    }

    public TermXY(TermX term) {
        super(term);
    }

    public TermXY(String termstr) {
        super(termstr);
    }
}
