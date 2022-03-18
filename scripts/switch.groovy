import groovy.transform.Immutable

interface Expr { }
@Immutable class IntExpr implements Expr { int i }
@Immutable class NegExpr implements Expr { Expr n }
@Immutable class AddExpr implements Expr { Expr left, right }
@Immutable class MulExpr implements Expr { Expr left, right }

int eval(Expr e) {
    e.with {
        switch(it) {
            case IntExpr -> i
            case NegExpr -> -eval(n)
            case AddExpr -> eval(left) + eval(right)
            case MulExpr -> eval(left) * eval(right)
            default -> throw new IllegalStateException()
        }
    }
}

@Newify(pattern=".*Expr")
def test() {
    def exprs = [
        IntExpr(4),
        NegExpr(IntExpr(4)),
        AddExpr(IntExpr(4), MulExpr(IntExpr(3), IntExpr(2))), // 4 + (3*2)
        MulExpr(IntExpr(4), AddExpr(IntExpr(3), IntExpr(2)))  // 4 * (3+2)
    ]
    assert exprs.collect { eval(it) } == [4, -4, 10, 20]
}

test()

