package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.Block;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Derivative;
import static org.matheclipse.core.expression.F.E;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.EvenQ;
import static org.matheclipse.core.expression.F.Expand;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.GCD;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.GreaterEqual;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Numerator;
import static org.matheclipse.core.expression.F.OddQ;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Product;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.SetDelayed;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialTest;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CoshQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.DerivativeDivides;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpnExpand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfHyperbolic;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfProductLog;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanWeight;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanhWeight;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonsumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonzeroQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalForm;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NotFalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerVariableExpn;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Regularize;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyExpression;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SinCosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SinQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SinhCoshQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SinhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SplitFreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerOfQuotientOfLinears;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForInverseLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigSimplify;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ZeroQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Catch;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Coefficient;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Coth;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Csch;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Erfi;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.FractionalPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Gamma;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.LinearSinCosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.LinearSinhCoshQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.PolynomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.ProductLog;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.SameQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Scan;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Sech;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Throw;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.TrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.TryTanSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.TryTanhSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.Unequal;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.UnsameQ;

import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IndefiniteIntegrationRules15 { 
  public static IAST RULES = List( 
SetDelayed(Int(Times(Power($p("x"),$p("m",true)),Times(Power(ProductLog(Times($p("a",true),Power($p("x"),$p("n")))),$p("p")),Power(Plus(C1,ProductLog(Times($p("a",true),Power($p("x"),$p("n"))))),CN1))),$p("x",$s("Symbol"))),
    Condition(Times(Times(Power($s("a"),Plus($s("p"),Times(CN1,C1D2))),Sqrt(Times(Times(CN1,Pi),Power(Plus($s("p"),Times(CN1,C1D2)),CN1)))),Times(Erfi(Sqrt(Times(Times(CN1,Plus($s("p"),Times(CN1,C1D2))),ProductLog(Times($s("a"),Power($s("x"),$s("n"))))))),Power($s("n"),CN1))),And(And(And(FreeQ(List($s("a"),$s("m"),$s("n")),$s("x")),IntegerQ(Plus($s("p"),Times(CN1,C1D2)))),Less($s("p"),C0)),ZeroQ(Plus(Plus($s("m"),Times($s("n"),Plus($s("p"),Times(CN1,C1D2)))),C1))))),
SetDelayed(Int(Times(Power($p("x"),$p("m",true)),Times(Power(ProductLog(Times($p("a",true),Power($p("x"),$p("n")))),$p("p",true)),Power(Plus(C1,ProductLog(Times($p("a",true),Power($p("x"),$p("n"))))),CN1))),$p("x",$s("Symbol"))),
    Condition(Plus(Times(Power($s("x"),Plus($s("m"),C1)),Times(Power(ProductLog(Times($s("a"),Power($s("x"),$s("n")))),Plus($s("p"),Times(CN1,C1))),Power(Plus($s("m"),C1),CN1))),Times(CN1,Dist(Times(Plus(Plus($s("m"),Times($s("n"),Plus($s("p"),Times(CN1,C1)))),C1),Power(Plus($s("m"),C1),CN1)),Int(Times(Power($s("x"),$s("m")),Times(Power(ProductLog(Times($s("a"),Power($s("x"),$s("n")))),Plus($s("p"),Times(CN1,C1))),Power(Plus(C1,ProductLog(Times($s("a"),Power($s("x"),$s("n"))))),CN1))),$s("x"))))),And(And(And(And(FreeQ($s("a"),$s("x")),RationalQ(List($s("m"),$s("n"),$s("p")))),Greater($s("n"),C0)),NonzeroQ(Plus($s("m"),C1))),Greater(Plus(Plus($s("m"),Times($s("n"),Plus($s("p"),Times(CN1,C1)))),C1),C0)))),
SetDelayed(Int(Times(Power($p("x"),$p("m",true)),Times(Power(ProductLog(Times($p("a",true),Power($p("x"),$p("n")))),$p("p",true)),Power(Plus(C1,ProductLog(Times($p("a",true),Power($p("x"),$p("n"))))),CN1))),$p("x",$s("Symbol"))),
    Condition(Plus(Times(Power($s("x"),Plus($s("m"),C1)),Times(Power(ProductLog(Times($s("a"),Power($s("x"),$s("n")))),$s("p")),Power(Plus(Plus($s("m"),Times($s("n"),$s("p"))),C1),CN1))),Times(CN1,Dist(Times(Plus($s("m"),C1),Power(Plus(Plus($s("m"),Times($s("n"),$s("p"))),C1),CN1)),Int(Times(Power($s("x"),$s("m")),Times(Power(ProductLog(Times($s("a"),Power($s("x"),$s("n")))),Plus($s("p"),C1)),Power(Plus(C1,ProductLog(Times($s("a"),Power($s("x"),$s("n"))))),CN1))),$s("x"))))),And(And(And(And(FreeQ($s("a"),$s("x")),RationalQ(List($s("m"),$s("n"),$s("p")))),Greater($s("n"),C0)),NonzeroQ(Plus($s("m"),C1))),Less(Plus(Plus($s("m"),Times($s("n"),$s("p"))),C1),C0)))),
SetDelayed(Int(Times(Power($p("x"),$p("m",true)),Times(Power(ProductLog(Times($p("a",true),Power($p("x"),$p("n")))),$p("p",true)),Power(Plus(C1,ProductLog(Times($p("a",true),Power($p("x"),$p("n"))))),CN1))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Subst(Int(Times(Power(ProductLog(Times($s("a"),Power($s("x"),Times(CN1,$s("n"))))),$s("p")),Power(Times(Power($s("x"),Plus($s("m"),C2)),Plus(C1,ProductLog(Times($s("a"),Power($s("x"),Times(CN1,$s("n"))))))),CN1)),$s("x")),$s("x"),Times(C1,Power($s("x"),CN1)))),And(And(And(FreeQ(List($s("a"),$s("p")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Less($s("n"),C0)),NonzeroQ(Plus($s("m"),C1))))),
SetDelayed(Int(Times(Power(Times(CN1,ProductLog(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("p",true)),Power(Plus(C1,ProductLog(Plus($p("a",true),Times($p("b",true),$p("x"))))),CN1)),$p("x",$s("Symbol"))),
    Condition(Times(Gamma(Plus($s("p"),C1),Times(CN1,ProductLog(Plus($s("a"),Times($s("b"),$s("x")))))),Power($s("b"),CN1)),FreeQ(List($s("a"),$s("b")),$s("x")))),
SetDelayed(Int(Power(Times(CN1,ProductLog(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("p")),$p("x",$s("Symbol"))),
    Condition(Plus(Int(Times(Power(Times(CN1,ProductLog(Plus($s("a"),Times($s("b"),$s("x"))))),$s("p")),Power(Plus(C1,ProductLog(Plus($s("a"),Times($s("b"),$s("x"))))),CN1)),$s("x")),Times(CN1,Int(Times(Power(Times(CN1,ProductLog(Plus($s("a"),Times($s("b"),$s("x"))))),Plus($s("p"),C1)),Power(Plus(C1,ProductLog(Plus($s("a"),Times($s("b"),$s("x"))))),CN1)),$s("x")))),FreeQ(List($s("a"),$s("b"),$s("p")),$s("x")))),
SetDelayed(Int(Times($p("u"),Power($p("x"),CN1)),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("lst"),FunctionOfProductLog($s("u"),$s("x")))),Condition(Dist(Times(C1,Power(Part($s("lst"),C3),CN1)),Subst(Int(Regularize(Times(Part($s("lst"),C1),Times(Plus(C1,$s("x")),Power($s("x"),CN1))),$s("x")),$s("x")),$s("x"),ProductLog(Part($s("lst"),C2)))),Not(FalseQ($s("lst"))))),NonsumQ($s("u")))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Subst(Int(Regularize(Times(Times(Plus($s("x"),C1),Power(E,$s("x"))),SubstFor(ProductLog($s("x")),$s("u"),$s("x"))),$s("x")),$s("x")),$s("x"),ProductLog($s("x"))),FunctionOfQ(ProductLog($s("x")),$s("u"),$s("x")))),
SetDelayed(Int($(Derivative($p("f")),$p("x")),$p("x",$s("Symbol"))),
    Condition($($s("f"),$s("x")),FreeQ($s("f"),$s("x")))),
SetDelayed(Int($($(Derivative($p("n")),$p("f")),$p("x")),$p("x",$s("Symbol"))),
    Condition($($(Derivative(Plus($s("n"),Times(CN1,C1))),$s("f")),$s("x")),FreeQ(List($s("f"),$s("n")),$s("x")))),
SetDelayed(Int(Times(Plus(Times($(Derivative($p("f")),$p("x")),$($p("g"),$p("x"))),Times(CN1,$(Derivative(Times($($p("f"),$p("x")),$p("g"))),$p("x")))),Power(Power($($p("g"),$p("x")),C2),CN1)),$p("x",$s("Symbol"))),
    Condition(Times($($s("f"),$s("x")),Power($($s("g"),$s("x")),CN1)),FreeQ(List($s("f"),$s("g")),$s("x")))),
SetDelayed(Int(Times(Plus(Times($(Derivative($p("f")),$p("x")),$($p("g"),$p("x"))),Times(CN1,$(Derivative(Times($($p("f"),$p("x")),$p("g"))),$p("x")))),Power(Times($($p("f"),$p("x")),$($p("g"),$p("x"))),CN1)),$p("x",$s("Symbol"))),
    Condition(Log(Times($($s("f"),$s("x")),Power($($s("g"),$s("x")),CN1))),FreeQ(List($s("f"),$s("g")),$s("x")))),
SetDelayed(Int(Times(Plus(Times($(Derivative($p("f")),$p("x")),$($p("g"),$p("x"))),Times(CN1,$(Derivative(Times($($p("f"),$p("x")),$p("g"))),$p("x")))),Power(Plus(Power($($p("f"),$p("x")),C2),Power($($p("g"),$p("x")),C2)),CN1)),$p("x",$s("Symbol"))),
    Condition(ArcTan(Times($($s("f"),$s("x")),Power($($s("g"),$s("x")),CN1))),FreeQ(List($s("f"),$s("g")),$s("x")))),
SetDelayed(Int(Times(Plus(Times($(Derivative($p("f")),$p("x")),$($p("g"),$p("x"))),Times(CN1,$(Derivative(Times($($p("f"),$p("x")),$p("g"))),$p("x")))),Power(Plus(Power($($p("f"),$p("x")),C2),Times(CN1,Power($($p("g"),$p("x")),C2))),CN1)),$p("x",$s("Symbol"))),
    Condition(Times(Log(Times(Plus($($s("f"),$s("x")),Times(CN1,$($s("g"),$s("x")))),Power(Plus($($s("f"),$s("x")),$($s("g"),$s("x"))),CN1))),C1D2),FreeQ(List($s("f"),$s("g")),$s("x")))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("v"),TrigSimplify($s("u")))),Condition(Int($s("v"),$s("x")),UnsameQ($s("v"),$s("u")))),Not(MatchQ($s("u"),Condition(Times(Times($p("w",true),Power(Plus($p("a",true),Times($p("b",true),$p("v"))),$p("m",true))),Power(Plus($p("c",true),Times($p("d",true),$p("v"))),$p("n",true))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Less($s("m"),C0)),Less($s("n"),C0))))))),
SetDelayed(Int(Times($p("u"),Power($p("x"),$p("m",true))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Plus($s("m"),C1),CN1)),Subst(Int(Regularize(SubstFor(Power($s("x"),Plus($s("m"),C1)),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Power($s("x"),Plus($s("m"),C1)))),And(And(FreeQ($s("m"),$s("x")),NonzeroQ(Plus($s("m"),C1))),FunctionOfQ(Power($s("x"),Plus($s("m"),C1)),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),$p("v")),$p("x",$s("Symbol"))),
    Module(List(Set($s("z"),DerivativeDivides($s("v"),$s("u"),$s("x")))),Condition(Dist($s("z"),Subst(Int($s("x"),$s("x")),$s("x"),$s("v"))),Not(FalseQ($s("z")))))),
SetDelayed(Int(Times(Times(Power($p("u1"),$p("n")),Power($p("u2"),$p("n"))),$p("v")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("w"),DerivativeDivides(Times($s("u1"),$s("u2")),$s("v"),$s("x")))),Condition(Times(Times($s("w"),Power($s("u1"),Plus($s("n"),C1))),Times(Power($s("u2"),Plus($s("n"),C1)),Power(Plus($s("n"),C1),CN1))),Not(FalseQ($s("w"))))),And(And(FreeQ($s("n"),$s("x")),NonzeroQ(Plus($s("n"),C1))),Or(Or(SumQ($s("v")),NonsumQ(Times($s("u1"),$s("u2")))),NonzeroQ(Plus($s("n"),Times(CN1,C1))))))),
SetDelayed(Int(Times(Times(Power($p("x"),$p("m",true)),Power($p("u"),$p("n",true))),$p("v")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("w"),DerivativeDivides(Times($s("x"),$s("u")),Times(Power($s("x"),Plus($s("m"),Times(CN1,$s("n")))),$s("v")),$s("x")))),Condition(Times(Times($s("w"),Power($s("x"),Plus($s("n"),C1))),Times(Power($s("u"),Plus($s("n"),C1)),Power(Plus($s("n"),C1),CN1))),Not(FalseQ($s("w"))))),And(And(FreeQ($s("n"),$s("x")),NonzeroQ(Plus($s("n"),C1))),Or(Or(SumQ($s("v")),NonsumQ($s("u"))),NonzeroQ(Plus($s("n"),Times(CN1,C1))))))),
SetDelayed(Int(Times(Times(Power($p("x"),$p("m",true)),Power($p("u"),$p("n",true))),$p("v")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("w"),DerivativeDivides($s("u"),$s("v"),$s("x")))),Condition(Plus(Times(Times($s("w"),Power($s("x"),$s("m"))),Times(Power($s("u"),Plus($s("n"),C1)),Power(Plus($s("n"),C1),CN1))),Times(CN1,Dist(Times(Times($s("m"),Power(Plus($s("n"),C1),CN1)),$s("w")),Int(Times(Power($s("x"),Plus($s("m"),Times(CN1,C1))),Power($s("u"),Plus($s("n"),C1))),$s("x"))))),Not(FalseQ($s("w"))))),And(And(And(And(FreeQ($s("n"),$s("x")),NonzeroQ(Plus($s("n"),C1))),RationalQ($s("m"))),Greater($s("m"),C0)),Or(Or(SumQ($s("v")),NonsumQ($s("u"))),NonzeroQ(Plus($s("n"),Times(CN1,C1))))))),
SetDelayed(Int(Times($p("u"),$p("v")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("w"),Block(List(Set($s("ShowSteps"),False),Set($s("StepCounter"),$s("Null"))),Int($s("v"),$s("x"))))),Condition(Subst(Int(Regularize(SubstFor($s("w"),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),$s("w")),FunctionOfQ($s("w"),$s("u"),$s("x")))),And(SumQ($s("v")),PolynomialQ($s("v"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Power(Plus($p("a",true),Times($p("b",true),$p("x"))),$p("m",true))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("b"),Plus($s("m"),C1)),CN1)),Subst(Int(Regularize(SubstFor(Power(Plus($s("a"),Times($s("b"),$s("x"))),Plus($s("m"),C1)),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Power(Plus($s("a"),Times($s("b"),$s("x"))),Plus($s("m"),C1)))),And(And(FreeQ(List($s("a"),$s("b"),$s("m")),$s("x")),NonzeroQ(Plus($s("m"),C1))),FunctionOfQ(Power(Plus($s("a"),Times($s("b"),$s("x"))),Plus($s("m"),C1)),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Power($p("x"),CN1)),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("lst"),PowerVariableExpn($s("u"),C0,$s("x")))),Condition(Dist(Times(C1,Power(Part($s("lst"),C2),CN1)),Subst(Int(Regularize(Times(Part($s("lst"),C1),Power($s("x"),CN1)),$s("x")),$s("x")),$s("x"),Power(Times(Part($s("lst"),C3),$s("x")),Part($s("lst"),C2)))),And(Not(FalseQ($s("lst"))),NonzeroQ(Part($s("lst"),C2))))),And(NonsumQ($s("u")),Not(RationalFunctionQ($s("u"),$s("x")))))),
SetDelayed(Int(Times($p("u"),Power($p("x"),$p("m",true))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("lst"),PowerVariableExpn($s("u"),Plus($s("m"),C1),$s("x")))),Condition(Dist(Times(C1,Power(Part($s("lst"),C2),CN1)),Subst(Int(Regularize(Times(Part($s("lst"),C1),Power($s("x"),CN1)),$s("x")),$s("x")),$s("x"),Power(Times(Part($s("lst"),C3),$s("x")),Part($s("lst"),C2)))),And(NotFalseQ($s("lst")),NonzeroQ(Plus(Plus(Part($s("lst"),C2),Times(CN1,$s("m"))),Times(CN1,C1)))))),And(And(And(IntegerQ($s("m")),Unequal($s("m"),CN1)),NonsumQ($s("u"))),Or(Greater($s("m"),C0),Not(AlgebraicFunctionQ($s("u"),$s("x"))))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Int(NormalForm(Expand(TrigReduce($s("u")),$s("x")),$s("x")),$s("x")),And(ProductQ($s("u")),Catch(CompoundExpression(Scan(Function(If(Not(LinearSinCosQ(Slot1,$s("x"))),Throw(False))),$s("u")),True))))),
SetDelayed(LinearSinCosQ(Power($p("u"),$p("n",true)),$p("x",$s("Symbol"))),
    And(And(And(IntegerQ($s("n")),Greater($s("n"),C0)),Or(SinQ($s("u")),CosQ($s("u")))),LinearQ(Part($s("u"),C1),$s("x")))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Int(NormalForm(Expand(TrigReduce($s("u")),$s("x")),$s("x")),$s("x")),And(ProductQ($s("u")),Catch(CompoundExpression(Scan(Function(If(Not(LinearSinhCoshQ(Slot1,$s("x"))),Throw(False))),$s("u")),True))))),
SetDelayed(LinearSinhCoshQ(Power($p("u"),$p("n",true)),$p("x",$s("Symbol"))),
    And(And(And(IntegerQ($s("n")),Greater($s("n"),C0)),Or(SinhQ($s("u")),CoshQ($s("u")))),LinearQ(Part($s("u"),C1),$s("x")))),
SetDelayed(Int(Times($p("u"),Sin(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x")))))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(SubstFor(Cos(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Cos(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x")))))))),And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),FunctionOfQ(Cos(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Cos(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x")))))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(SubstFor(Sin(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Sin(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))))),And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),FunctionOfQ(Sin(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Power(Sec(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("n"))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(Times(Power(Plus(C1,Power($s("x"),C2)),Times(Plus($s("n"),Times(CN1,C2)),C1D2)),SubstFor(Tan(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),$s("x")),$s("x")),$s("x"),Tan(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),EvenQ($s("n"))),FunctionOfQ(Tan(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),NonsumQ($s("u"))))),
SetDelayed(Int(Times($p("u"),Power(Csc(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("n"))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(Times(Power(Plus(C1,Power($s("x"),C2)),Times(Plus($s("n"),Times(CN1,C2)),C1D2)),SubstFor(Cot(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),$s("x")),$s("x")),$s("x"),Cot(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x")))))))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),EvenQ($s("n"))),FunctionOfQ(Cot(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),NonsumQ($s("u"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("v"),FunctionOfTrig($s("u"),$s("x")))),Condition(Dist(Times(C1,Power(Coefficient($s("v"),$s("x"),C1),CN1)),Subst(Int(Regularize(SubstFor(Sin($s("v")),Times($s("u"),Power(Cos($s("v")),CN1)),$s("x")),$s("x")),$s("x")),$s("x"),Sin($s("v")))),And(NotFalseQ($s("v")),FunctionOfQ(Sin($s("v")),Times($s("u"),Power(Cos($s("v")),CN1)),$s("x")))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("v"),FunctionOfTrig($s("u"),$s("x")))),Condition(Times(CN1,Dist(Times(C1,Power(Coefficient($s("v"),$s("x"),C1),CN1)),Subst(Int(Regularize(SubstFor(Cos($s("v")),Times($s("u"),Power(Sin($s("v")),CN1)),$s("x")),$s("x")),$s("x")),$s("x"),Cos($s("v"))))),And(NotFalseQ($s("v")),FunctionOfQ(Cos($s("v")),Times($s("u"),Power(Sin($s("v")),CN1)),$s("x")))))),
SetDelayed(Int(Times(Times($p("u"),Sec(Plus($p("a",true),Times($p("b",true),$p("x"))))),Csc(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power($s("b"),CN1)),Subst(Int(Regularize(SubstFor(Log(Tan(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Log(Tan(Plus($s("a"),Times($s("b"),$s("x"))))))),And(FreeQ(List($s("a"),$s("b")),$s("x")),FunctionOfQ(Log(Tan(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times(Times($p("u"),Sec(Plus($p("a",true),Times($p("b",true),$p("x"))))),Csc(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Dist(Times(C1,Power($s("b"),CN1)),Subst(Int(Regularize(SubstFor(Log(Cot(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Log(Cot(Plus($s("a"),Times($s("b"),$s("x")))))))),And(FreeQ(List($s("a"),$s("b")),$s("x")),FunctionOfQ(Log(Cot(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Cos(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C2,Power($s("b"),CN1)),Subst(Int(Regularize(SubstFor(Times(Cos(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x")))),Sin(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Times(Cos(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x")))),Sin(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x"))))))),And(And(NonsumQ($s("u")),FreeQ(List($s("a"),$s("b")),$s("x"))),FunctionOfQ(Times(Cos(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x")))),Sin(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Sinh(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x")))))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(SubstFor(Cosh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Cosh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))))),And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),FunctionOfQ(Cosh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Cosh(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x")))))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(SubstFor(Sinh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Sinh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))))),And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),FunctionOfQ(Sinh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Power(Sech(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("n"))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(Times(Power(Plus(C1,Times(CN1,Power($s("x"),C2))),Times(Plus($s("n"),Times(CN1,C2)),C1D2)),SubstFor(Tanh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),$s("x")),$s("x")),$s("x"),Tanh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),EvenQ($s("n"))),FunctionOfQ(Tanh(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),NonsumQ($s("u"))))),
SetDelayed(Int(Times($p("u"),Power(Csch(Times($p("c",true),Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("n"))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Dist(Times(C1,Power(Times($s("b"),$s("c")),CN1)),Subst(Int(Regularize(Times(Power(Plus(CN1,Power($s("x"),C2)),Times(Plus($s("n"),Times(CN1,C2)),C1D2)),SubstFor(Coth(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),$s("x")),$s("x")),$s("x"),Coth(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x")))))))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),EvenQ($s("n"))),FunctionOfQ(Coth(Times($s("c"),Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))),NonsumQ($s("u"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("v"),FunctionOfHyperbolic($s("u"),$s("x")))),Condition(Dist(Times(C1,Power(Coefficient($s("v"),$s("x"),C1),CN1)),Subst(Int(Regularize(SubstFor(Sinh($s("v")),Times($s("u"),Power(Cosh($s("v")),CN1)),$s("x")),$s("x")),$s("x")),$s("x"),Sinh($s("v")))),And(NotFalseQ($s("v")),FunctionOfQ(Sinh($s("v")),Times($s("u"),Power(Cosh($s("v")),CN1)),$s("x")))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("v"),FunctionOfHyperbolic($s("u"),$s("x")))),Condition(Dist(Times(C1,Power(Coefficient($s("v"),$s("x"),C1),CN1)),Subst(Int(Regularize(SubstFor(Cosh($s("v")),Times($s("u"),Power(Sinh($s("v")),CN1)),$s("x")),$s("x")),$s("x")),$s("x"),Cosh($s("v")))),And(NotFalseQ($s("v")),FunctionOfQ(Cosh($s("v")),Times($s("u"),Power(Sinh($s("v")),CN1)),$s("x")))))),
SetDelayed(Int(Times(Times($p("u"),Sech(Plus($p("a",true),Times($p("b",true),$p("x"))))),Csch(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power($s("b"),CN1)),Subst(Int(Regularize(SubstFor(Log(Tanh(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Log(Tanh(Plus($s("a"),Times($s("b"),$s("x"))))))),And(FreeQ(List($s("a"),$s("b")),$s("x")),FunctionOfQ(Log(Tanh(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times(Times($p("u"),Sech(Plus($p("a",true),Times($p("b",true),$p("x"))))),Csch(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Dist(Times(C1,Power($s("b"),CN1)),Subst(Int(Regularize(SubstFor(Log(Coth(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Log(Coth(Plus($s("a"),Times($s("b"),$s("x")))))))),And(FreeQ(List($s("a"),$s("b")),$s("x")),FunctionOfQ(Log(Coth(Plus($s("a"),Times($s("b"),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times($p("u"),Cosh(Plus($p("a",true),Times($p("b",true),$p("x"))))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C2,Power($s("b"),CN1)),Subst(Int(Regularize(SubstFor(Times(Cosh(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x")))),Sinh(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x"))))),$s("u"),$s("x")),$s("x")),$s("x")),$s("x"),Times(Cosh(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x")))),Sinh(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x"))))))),And(And(NonsumQ($s("u")),FreeQ(List($s("a"),$s("b")),$s("x"))),FunctionOfQ(Times(Cosh(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x")))),Sinh(Plus(Times($s("a"),C1D2),Times(Times($s("b"),C1D2),$s("x"))))),$s("u"),$s("x"))))),
SetDelayed(Int(Times(Times(Power($p("x"),$p("m",true)),Power($p("u"),Plus(CN1,Times($p("a",true),Power($p("x"),$p("m",true)))))),$p("v")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("w"),DerivativeDivides($s("u"),$s("v"),$s("x")))),Condition(Plus(Times($s("w"),Times(Power($s("u"),Times($s("a"),Power($s("x"),$s("m")))),Power($s("a"),CN1))),Times(CN1,Dist(Times($s("m"),$s("w")),Int(Times(Times(Power($s("x"),Plus($s("m"),Times(CN1,C1))),Power($s("u"),Times($s("a"),Power($s("x"),$s("m"))))),Log($s("u"))),$s("x"))))),Not(FalseQ($s("w"))))),And(And(FreeQ($s("a"),$s("x")),RationalQ($s("m"))),Greater($s("m"),C0)))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Subst(Int(Regularize(Times(SubstFor(Tan($s("x")),$s("u"),$s("x")),Power(Plus(C1,Power($s("x"),C2)),CN1)),$s("x")),$s("x")),$s("x"),Tan($s("x"))),And(And(FunctionOfQ(Tan($s("x")),$s("u"),$s("x")),GreaterEqual(FunctionOfTanWeight($s("u"),$s("x"),$s("x")),C0)),TryTanSubst($s("u"),$s("x"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Subst(Int(Regularize(Times(SubstFor(Cot($s("x")),$s("u"),$s("x")),Power(Plus(C1,Power($s("x"),C2)),CN1)),$s("x")),$s("x")),$s("x"),Cot($s("x")))),And(And(FunctionOfQ(Cot($s("x")),$s("u"),$s("x")),Less(FunctionOfTanWeight($s("u"),$s("x"),$s("x")),C0)),TryTanSubst($s("u"),$s("x"))))),
SetDelayed(TryTanSubst($p("u"),$p("x",$s("Symbol"))),
    And(And(And(And(And(And(FalseQ(FunctionOfLinear($s("u"),$s("x"))),Not(MatchQ($s("u"),Condition(Times($p("r",true),Power(Plus($p("s"),$p("t")),$p("n",true))),And(IntegerQ($s("n")),Greater($s("n"),C0)))))),Not(MatchQ($s("u"),Condition(Log(Power($($p("f"),$s("x")),C2)),SinCosQ($s("f")))))),Not(MatchQ($s("u"),Condition(Times(C1,Power(Plus($p("a"),Times($p("b",true),Power($($p("f"),$s("x")),$p("n")))),CN1)),And(And(SinCosQ($s("f")),IntegerQ($s("n"))),Greater($s("n"),C2)))))),Not(MatchQ($s("u"),Condition(Times($($p("f"),Times($p("m",true),$s("x"))),$($p("g"),Times($p("n",true),$s("x")))),And(And(IntegerQ(List($s("m"),$s("n"))),SinCosQ($s("f"))),SinCosQ($s("g"))))))),Not(MatchQ($s("u"),Condition(Times($p("r",true),Power(Times($p("a",true),Power($p("s"),$p("m"))),$p("p"))),And(FreeQ(List($s("a"),$s("m"),$s("p")),$s("x")),Not(And(SameQ($s("m"),C2),Or(SameQ($s("s"),Sec($s("x"))),SameQ($s("s"),Csc($s("x"))))))))))),SameQ($s("u"),ExpnExpand($s("u"),$s("x"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Subst(Int(Regularize(Times(SubstFor(Tanh($s("x")),$s("u"),$s("x")),Power(Plus(C1,Times(CN1,Power($s("x"),C2))),CN1)),$s("x")),$s("x")),$s("x"),Tanh($s("x"))),And(And(FunctionOfQ(Tanh($s("x")),$s("u"),$s("x")),GreaterEqual(FunctionOfTanhWeight($s("u"),$s("x"),$s("x")),C0)),TryTanhSubst($s("u"),$s("x"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Subst(Int(Regularize(Times(SubstFor(Coth($s("x")),$s("u"),$s("x")),Power(Plus(C1,Times(CN1,Power($s("x"),C2))),CN1)),$s("x")),$s("x")),$s("x"),Coth($s("x"))),And(And(FunctionOfQ(Coth($s("x")),$s("u"),$s("x")),Less(FunctionOfTanhWeight($s("u"),$s("x"),$s("x")),C0)),TryTanhSubst($s("u"),$s("x"))))),
SetDelayed(TryTanhSubst($p("u"),$p("x",$s("Symbol"))),
    And(And(And(And(And(And(FalseQ(FunctionOfLinear($s("u"),$s("x"))),Not(MatchQ($s("u"),Condition(Times($p("r",true),Power(Plus($p("s"),$p("t")),$p("n",true))),And(IntegerQ($s("n")),Greater($s("n"),C0)))))),Not(MatchQ($s("u"),Condition(Log(Power($($p("f"),$s("x")),C2)),SinhCoshQ($s("f")))))),Not(MatchQ($s("u"),Condition(Times(C1,Power(Plus($p("a"),Times($p("b",true),Power($($p("f"),$s("x")),$p("n")))),CN1)),And(And(SinhCoshQ($s("f")),IntegerQ($s("n"))),Greater($s("n"),C2)))))),Not(MatchQ($s("u"),Condition(Times($($p("f"),Times($p("m",true),$s("x"))),$($p("g"),Times($p("n",true),$s("x")))),And(And(IntegerQ(List($s("m"),$s("n"))),SinhCoshQ($s("f"))),SinhCoshQ($s("g"))))))),Not(MatchQ($s("u"),Condition(Times($p("r",true),Power(Times($p("a",true),Power($p("s"),$p("m"))),$p("p"))),And(FreeQ(List($s("a"),$s("m"),$s("p")),$s("x")),Not(And(SameQ($s("m"),C2),Or(SameQ($s("s"),Sech($s("x"))),SameQ($s("s"),Csch($s("x"))))))))))),SameQ($s("u"),ExpnExpand($s("u"),$s("x"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("lst"),FunctionOfExponentialOfLinear($s("u"),$s("x")))),Condition(Dist(Times(C1,Power(Times(Part($s("lst"),C3),Log(Part($s("lst"),C4))),CN1)),Subst(Int(Regularize(Times(Part($s("lst"),C1),Power($s("x"),CN1)),$s("x")),$s("x")),$s("x"),Power(Part($s("lst"),C4),Plus(Part($s("lst"),C2),Times(Part($s("lst"),C3),$s("x")))))),Not(FalseQ($s("lst"))))),And(And(And(Not(MatchQ($s("u"),Condition(Power($p("v"),$p("n",true)),And(And(SumQ($s("v")),IntegerQ($s("n"))),Greater($s("n"),C0))))),Not(MatchQ($s("u"),Condition(Times(Power($p("v"),$p("n",true)),Power($p("f"),Plus($p("a",true),Times($p("b",true),$s("x"))))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("f")),$s("x")),SumQ($s("v"))),IntegerQ($s("n"))),Greater($s("n"),C0)))))),Not(MatchQ($s("u"),Condition(Times(C1,Power(Plus(Plus($p("a",true),Times($p("b",true),Power($p("f"),Plus($p("d",true),Times($p("e",true),$s("x")))))),Times($p("c",true),Power($p("f"),Plus($p("g",true),Times($p("h",true),$s("x")))))),CN1)),And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e"),$s("f"),$s("g"),$s("h")),$s("x")),ZeroQ(Plus($s("g"),Times(CN1,Times(C2,$s("d")))))),ZeroQ(Plus($s("h"),Times(CN1,Times(C2,$s("e")))))))))),FalseQ(FunctionOfHyperbolic($s("u"),$s("x")))))),
SetDelayed(Int(Times(Power($p("x"),$p("m",true)),Power($p("f"),Plus($p("a",true),Times($p("b",true),Power($p("x"),$p("n",true)))))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Subst(Int(Times(Power($s("f"),Plus($s("a"),Times($s("b"),Power($s("x"),Times(CN1,$s("n")))))),Power(Power($s("x"),Plus($s("m"),C2)),CN1)),$s("x")),$s("x"),Times(C1,Power($s("x"),CN1)))),And(And(And(And(FreeQ(List($s("a"),$s("b"),$s("f")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Less($s("n"),C0)),Less($s("m"),CN1)),Equal(GCD(Plus($s("m"),C1),$s("n")),C1)))),
SetDelayed(Int(Times(Power($p("x"),$p("m",true)),Power($($p("f"),Plus($p("a",true),Times($p("b",true),Power($p("x"),$p("n"))))),$p("p",true))),$p("x",$s("Symbol"))),
    Condition(Times(CN1,Subst(Int(Times(Power($($s("f"),Plus($s("a"),Times($s("b"),Power($s("x"),Times(CN1,$s("n")))))),$s("p")),Power(Power($s("x"),Plus($s("m"),C2)),CN1)),$s("x")),$s("x"),Times(C1,Power($s("x"),CN1)))),And(And(And(And(FreeQ(List($s("a"),$s("b"),$s("f"),$s("p")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Less($s("n"),C0)),Less($s("m"),CN1)),Equal(GCD(Plus($s("m"),C1),$s("n")),C1)))),
SetDelayed(Int(Times($p("u"),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n")))),$p("m"))),$p("x",$s("Symbol"))),
    Condition(Times(Times(Power(Plus($s("a"),Times($s("b"),Power($s("x"),$s("n")))),$s("m")),Power(Times(Power($s("x"),Times($s("m"),$s("n"))),Power(Plus($s("b"),Times($s("a"),Power(Power($s("x"),$s("n")),CN1))),$s("m"))),CN1)),Int(Times(Times($s("u"),Power($s("x"),Times($s("m"),$s("n")))),Power(Plus($s("b"),Times($s("a"),Power(Power($s("x"),$s("n")),CN1))),$s("m"))),$s("x"))),And(And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),FractionQ($s("m"))),IntegerQ($s("n"))),Less($s("n"),CN1)),SameQ($s("u"),ExpnExpand($s("u"),$s("x")))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),SubstForFractionalPowerOfLinear($s("u"),$s("x")))),Condition(Dist(Times(Part($s("lst"),C2),Part($s("lst"),C4)),Subst(Int(Part($s("lst"),C1),$s("x")),$s("x"),Power(Part($s("lst"),C3),Times(C1,Power(Part($s("lst"),C2),CN1))))),And(NotFalseQ($s("lst")),SubstForFractionalPowerQ($s("u"),Part($s("lst"),C3),$s("x")))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),SubstForFractionalPowerOfQuotientOfLinears($s("u"),$s("x")))),Condition(Dist(Times(Part($s("lst"),C2),Part($s("lst"),C4)),Subst(Int(Part($s("lst"),C1),$s("x")),$s("x"),Power(Part($s("lst"),C3),Times(C1,Power(Part($s("lst"),C2),CN1))))),NotFalseQ($s("lst"))))),
SetDelayed(Int(Times($p("u"),Power(Plus($p("a"),Times($p("b",true),$p("x"))),$p("m",true))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power($s("b"),CN1)),Subst(Int(Times(Power($s("x"),$s("m")),Regularize(SubstFor(Plus($s("a"),Times($s("b"),$s("x"))),$s("u"),$s("x")),$s("x"))),$s("x")),$s("x"),Plus($s("a"),Times($s("b"),$s("x"))))),And(FreeQ(List($s("a"),$s("b"),$s("m")),$s("x")),FunctionOfQ(Plus($s("a"),Times($s("b"),$s("x"))),$s("u"),$s("x"))))),
SetDelayed(Int(Times(Power($p("x"),$p("m",true)),Power(Plus($p("a"),Times($p("b",true),Power(Plus($p("c"),Times($p("d",true),$p("x"))),$p("n")))),CN1)),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power($s("d"),CN1)),Subst(Int(Times(Power(Plus(Times(Times(CN1,$s("c")),Power($s("d"),CN1)),Times($s("x"),Power($s("d"),CN1))),$s("m")),Power(Plus($s("a"),Times($s("b"),Power($s("x"),$s("n")))),CN1)),$s("x")),$s("x"),Plus($s("c"),Times($s("d"),$s("x"))))),And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Greater($s("n"),C2)))),
SetDelayed(Int(Times(Power(Plus($p("e"),Times($p("f",true),$p("x"))),$p("m",true)),Power(Plus($p("a"),Times($p("b",true),Power(Plus($p("c"),Times($p("d",true),$p("x"))),$p("n")))),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(Power(Times($s("f"),Power($s("d"),CN1)),$s("m")),Power($s("d"),CN1)),Subst(Int(Times(Power($s("x"),$s("m")),Power(Plus($s("a"),Times($s("b"),Power($s("x"),$s("n")))),$s("p"))),$s("x")),$s("x"),Plus($s("c"),Times($s("d"),$s("x"))))),And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e"),$s("f")),$s("x")),IntegerQ(List($s("m"),$s("n"),$s("p")))),ZeroQ(Plus(Times($s("d"),$s("e")),Times(CN1,Times($s("c"),$s("f")))))))),
SetDelayed(Int(Times(Power(Plus($p("a",true),Times($p("b",true),$p("x"))),$p("m",true)),Power($($p("f"),Plus($p("c",true),Times($p("d",true),$p("x")))),$p("p",true))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power($s("b"),CN1)),Subst(Int(Times(Power($s("x"),$s("m")),Power($($s("f"),Plus(Plus($s("c"),Times(CN1,Times($s("a"),Times($s("d"),Power($s("b"),CN1))))),Times($s("d"),Times($s("x"),Power($s("b"),CN1))))),$s("p"))),$s("x")),$s("x"),Plus($s("a"),Times($s("b"),$s("x"))))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("m")),$s("x")),RationalQ($s("p"))),Not(And(SameQ($s("a"),C0),SameQ($s("b"),C1)))),MemberQ(List($s("Sin"),$s("Cos"),$s("Sec"),$s("Csc"),$s("Sinh"),$s("Cosh"),$s("Sech"),$s("Csch")),$s("f"))))),
SetDelayed(Int(Times(Power(Plus($p("a",true),Times($p("b",true),$p("x"))),$p("m")),Power(Plus(Plus($p("c",true),Times($p("d",true),$p("x"))),Times($p("e",true),Power($p("x"),C2))),$p("n"))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power($s("b"),CN1)),Subst(Int(Times(Power($s("x"),$s("m")),Power(Plus(Plus(Plus(Plus($s("c"),Times(CN1,Times($s("a"),Times($s("d"),Power($s("b"),CN1))))),Times(Power($s("a"),C2),Times($s("e"),Power(Power($s("b"),C2),CN1)))),Times(Plus(Times($s("d"),Power($s("b"),CN1)),Times(CN1,Times(Times(C2,$s("a")),Times($s("e"),Power(Power($s("b"),C2),CN1))))),$s("x"))),Times($s("e"),Times(Power($s("x"),C2),Power(Power($s("b"),C2),CN1)))),$s("n"))),$s("x")),$s("x"),Plus($s("a"),Times($s("b"),$s("x"))))),And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e"),$s("m"),$s("n")),$s("x")),FractionQ($s("n"))),Not(And(SameQ($s("a"),C0),SameQ($s("b"),C1)))))),
SetDelayed(Int(Times(Power(Plus($p("u"),Power($p("x"),$p("p",true))),$p("n")),$p("v")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("z"),DerivativeDivides($s("u"),$s("v"),$s("x")))),Condition(Plus(Times($s("z"),Times(Power(Plus($s("u"),Power($s("x"),$s("p"))),Plus($s("n"),C1)),Power(Plus($s("n"),C1),CN1))),Times(CN1,Dist(Times($s("z"),$s("p")),Int(Times(Power($s("x"),Plus($s("p"),Times(CN1,C1))),Power(Plus($s("u"),Power($s("x"),$s("p"))),$s("n"))),$s("x"))))),Not(FalseQ($s("z"))))),And(And(And(IntegerQ($s("p")),RationalQ($s("n"))),NonzeroQ(Plus($s("n"),C1))),Not(AlgebraicFunctionQ($s("v"),$s("x")))))),
SetDelayed(Int(Times(Times(Power($p("x"),$p("m",true)),Power(Plus($p("u"),Power($p("x"),$p("p",true))),$p("n"))),$p("v")),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("z"),DerivativeDivides($s("u"),$s("v"),$s("x")))),Condition(Plus(Plus(Times(Times($s("z"),Power($s("x"),$s("m"))),Times(Power(Plus($s("u"),Power($s("x"),$s("p"))),Plus($s("n"),C1)),Power(Plus($s("n"),C1),CN1))),Times(CN1,Dist(Times($s("z"),$s("p")),Int(Times(Power($s("x"),Plus(Plus($s("m"),$s("p")),Times(CN1,C1))),Power(Plus($s("u"),Power($s("x"),$s("p"))),$s("n"))),$s("x"))))),Times(CN1,Dist(Times($s("z"),Times($s("m"),Power(Plus($s("n"),C1),CN1))),Int(Times(Power($s("x"),Plus($s("m"),Times(CN1,C1))),Power(Plus($s("u"),Power($s("x"),$s("p"))),Plus($s("n"),C1))),$s("x"))))),Not(FalseQ($s("z"))))),And(And(IntegerQ(List($s("m"),$s("p"))),RationalQ($s("n"))),NonzeroQ(Plus($s("n"),C1))))),
SetDelayed(Int(Log($p("u")),$p("x",$s("Symbol"))),
    Condition(Plus(Times($s("x"),Log($s("u"))),Times(CN1,Int(Regularize(Times($s("x"),Times(D($s("u"),$s("x")),Power($s("u"),CN1))),$s("x")),$s("x")))),InverseFunctionFreeQ($s("u"),$s("x")))),
SetDelayed(Int(Times(Log($p("u")),Power($p("x"),CN1)),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("v"),Times(D($s("u"),$s("x")),Power($s("u"),CN1)))),Condition(Plus(Times(Log($s("u")),Log($s("x"))),Times(CN1,Int(Regularize(Times(Log($s("x")),$s("v")),$s("x")),$s("x")))),RationalFunctionQ($s("v"),$s("x")))),Not(And(BinomialTest($s("u"),$s("x")),SameQ(Power(Part(BinomialTest($s("u"),$s("x")),C3),C2),C1))))),
SetDelayed(Int(Times(Log($p("u")),Power(Plus($p("a"),Times($p("b",true),$p("x"))),CN1)),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("v"),Times(D($s("u"),$s("x")),Power($s("u"),CN1)))),Condition(Plus(Times(Log($s("u")),Times(Log(Plus($s("a"),Times($s("b"),$s("x")))),Power($s("b"),CN1))),Times(CN1,Dist(Times(C1,Power($s("b"),CN1)),Int(Regularize(Times(Log(Plus($s("a"),Times($s("b"),$s("x")))),$s("v")),$s("x")),$s("x"))))),RationalFunctionQ($s("v"),$s("x")))),FreeQ(List($s("a"),$s("b")),$s("x")))),
SetDelayed(Int(Times(Power(Plus($p("a",true),Times($p("b",true),$p("x"))),$p("m",true)),Log($p("u"))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("v"),Times(D($s("u"),$s("x")),Power($s("u"),CN1)))),Plus(Times(Power(Plus($s("a"),Times($s("b"),$s("x"))),Plus($s("m"),C1)),Times(Log($s("u")),Power(Times($s("b"),Plus($s("m"),C1)),CN1))),Times(CN1,Dist(Times(C1,Power(Times($s("b"),Plus($s("m"),C1)),CN1)),Int(Regularize(Times(Power(Plus($s("a"),Times($s("b"),$s("x"))),Plus($s("m"),C1)),$s("v")),$s("x")),$s("x")))))),And(And(And(And(FreeQ(List($s("a"),$s("b"),$s("m")),$s("x")),NonzeroQ(Plus($s("m"),C1))),InverseFunctionFreeQ($s("u"),$s("x"))),Not(FunctionOfQ(Power($s("x"),Plus($s("m"),C1)),$s("u"),$s("x")))),FalseQ(PowerVariableExpn($s("u"),Plus($s("m"),C1),$s("x")))))),
SetDelayed(Int(Times($p("v"),Log($p("u"))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("w"),Block(List(Set($s("ShowSteps"),False),Set($s("StepCounter"),$s("Null"))),Int($s("v"),$s("x"))))),Condition(Plus(Times($s("w"),Log($s("u"))),Times(CN1,Int(Regularize(Times($s("w"),Times(D($s("u"),$s("x")),Power($s("u"),CN1))),$s("x")),$s("x")))),InverseFunctionFreeQ($s("w"),$s("x")))),And(And(InverseFunctionFreeQ($s("u"),$s("x")),Not(MatchQ($s("v"),Condition(Power($s("x"),$p("m",true)),FreeQ($s("m"),$s("x")))))),FalseQ(FunctionOfLinear(Times($s("v"),Log($s("u"))),$s("x")))))),
SetDelayed(Int(Times($p("u",true),Times($p("x"),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),C2))),CN1))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("q"),Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),C2))),Plus(Dist(Times($s("q"),C1D2),Int(Times($s("u"),Power(Plus($s("a"),Times(Times($s("b"),$s("q")),$s("x"))),CN1)),$s("x"))),Times(CN1,Dist(Times($s("q"),C1D2),Int(Times($s("u"),Power(Plus($s("a"),Times(CN1,Times(Times($s("b"),$s("q")),$s("x")))),CN1)),$s("x")))))),And(And(FreeQ(List($s("a"),$s("b")),$s("x")),Not(MatchQ($s("u"),Condition(Times($p("r"),$p("s",true)),SumQ($s("r")))))),Not(RationalFunctionQ($s("u"),$s("x")))))),
SetDelayed(Int(Times($p("u",true),Times(Power($p("v"),$p("m",true)),Power(Plus(Plus($p("a"),Times($p("b",true),$p("v"))),Times($p("c",true),$p("w"))),CN1))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("q"),Rt(Plus(Power($s("b"),C2),Times(CN1,Times(Times(C4,$s("a")),$s("c")))),C2))),Condition(Plus(Dist(Plus(C1,Times($s("b"),Power($s("q"),CN1))),Int(Times($s("u"),Times(Power($s("v"),Plus($s("m"),Times(CN1,C1))),Power(Plus(Plus($s("b"),$s("q")),Times(Times(C2,$s("c")),$s("v"))),CN1))),$s("x"))),Dist(Plus(C1,Times(CN1,Times($s("b"),Power($s("q"),CN1)))),Int(Times($s("u"),Times(Power($s("v"),Plus($s("m"),Times(CN1,C1))),Power(Plus(Plus($s("b"),Times(CN1,$s("q"))),Times(Times(C2,$s("c")),$s("v"))),CN1))),$s("x")))),NonzeroQ($s("q")))),And(And(And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),RationalQ($s("m"))),Equal($s("m"),C1)),ZeroQ(Plus($s("w"),Times(CN1,Power($s("v"),C2))))),Not(MatchQ($s("u"),Condition(Times($p("r"),$p("s",true)),SumQ($s("r")))))),Or(Not(RationalFunctionQ($s("u"),$s("x"))),Not(RationalFunctionQ($s("v"),$s("x"))))))),
SetDelayed(Int(Times(Plus($p("d",true),Times($p("e",true),$p("v"))),Power(Plus(Plus($p("a"),Times($p("b",true),$p("v"))),Times($p("c",true),$p("w"))),CN1)),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("q"),Rt(Plus(Power($s("b"),C2),Times(CN1,Times(Times(C4,$s("a")),$s("c")))),C2))),Condition(Plus(Dist(Plus($s("e"),Times(Plus(Times($s("b"),$s("e")),Times(CN1,Times(Times(C2,$s("c")),$s("d")))),Power($s("q"),CN1))),Int(Times(C1,Power(Plus(Plus($s("b"),$s("q")),Times(Times(C2,$s("c")),$s("v"))),CN1)),$s("x"))),Dist(Plus($s("e"),Times(CN1,Times(Plus(Times($s("b"),$s("e")),Times(CN1,Times(Times(C2,$s("c")),$s("d")))),Power($s("q"),CN1)))),Int(Times(C1,Power(Plus(Plus($s("b"),Times(CN1,$s("q"))),Times(Times(C2,$s("c")),$s("v"))),CN1)),$s("x")))),NonzeroQ($s("q")))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c"),$s("d"),$s("e")),$s("x")),ZeroQ(Plus($s("w"),Times(CN1,Power($s("v"),C2))))),NonzeroQ(Plus(Times(Times(C2,$s("c")),$s("d")),Times(CN1,Times($s("b"),$s("e")))))),Not(RationalFunctionQ($s("v"),$s("x")))))),
SetDelayed(Int(Times($p("u",true),Power(Plus(Plus($p("a"),Times($p("b",true),$p("v"))),Times($p("c",true),$p("w"))),CN1)),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("q"),Rt(Plus(Power($s("b"),C2),Times(CN1,Times(Times(C4,$s("a")),$s("c")))),C2))),Condition(Plus(Dist(Times(C2,Times($s("c"),Power($s("q"),CN1))),Int(Times($s("u"),Power(Plus(Plus($s("b"),Times(CN1,$s("q"))),Times(Times(C2,$s("c")),$s("v"))),CN1)),$s("x"))),Times(CN1,Dist(Times(C2,Times($s("c"),Power($s("q"),CN1))),Int(Times($s("u"),Power(Plus(Plus($s("b"),$s("q")),Times(Times(C2,$s("c")),$s("v"))),CN1)),$s("x"))))),NonzeroQ($s("q")))),And(And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),ZeroQ(Plus($s("w"),Times(CN1,Power($s("v"),C2))))),Not(MatchQ($s("u"),Condition(Power($s("v"),$p("m")),RationalQ($s("m")))))),Not(MatchQ($s("u"),Condition(Times($p("r"),$p("s",true)),SumQ($s("r")))))),Or(Not(RationalFunctionQ($s("u"),$s("x"))),Not(RationalFunctionQ($s("v"),$s("x"))))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("v"),SimplifyExpression($s("u"),$s("x")))),Condition(Int($s("v"),$s("x")),UnsameQ($s("v"),$s("u"))))),
SetDelayed(Int(Times($p("u",true),Power(Times(Times(Power($p("v"),$p("m",true)),Power($p("w"),$p("n",true))),Power($p("t"),$p("q",true))),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Int(Times(Times(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),Power($s("w"),Times($s("n"),$s("p")))),Power($s("t"),Times($s("p"),$s("q")))),$s("x")),And(And(And(And(FreeQ($s("p"),$s("x")),Not(PowerQ($s("v")))),Not(PowerQ($s("w")))),Not(PowerQ($s("t")))),ZeroQ(Simplify(Plus(Power(Times(Times(Power($s("v"),$s("m")),Power($s("w"),$s("n"))),Power($s("t"),$s("q"))),$s("p")),Times(CN1,Times(Times(Power($s("v"),Times($s("m"),$s("p"))),Power($s("w"),Times($s("n"),$s("p")))),Power($s("t"),Times($s("p"),$s("q"))))))))))),
SetDelayed(Int(Times($p("u",true),Power(Times(Times(Power($p("v"),$p("m",true)),Power($p("w"),$p("n",true))),Power($p("t"),$p("q",true))),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("r"),Simplify(Times(Power(Times(Times(Power($s("v"),$s("m")),Power($s("w"),$s("n"))),Power($s("t"),$s("q"))),$s("p")),Power(Times(Times(Power($s("v"),Times($s("m"),$s("p"))),Power($s("w"),Times($s("n"),$s("p")))),Power($s("t"),Times($s("p"),$s("q")))),CN1)))),$s("lst")),Condition(CompoundExpression(Set($s("lst"),SplitFreeFactors(Times(Times(Power($s("v"),Times($s("m"),$s("p"))),Power($s("w"),Times($s("n"),$s("p")))),Power($s("t"),Times($s("p"),$s("q")))),$s("x"))),Times(Times($s("r"),Part($s("lst"),C1)),Int(Regularize(Times($s("u"),Part($s("lst"),C2)),$s("x")),$s("x")))),NonzeroQ(Plus($s("r"),Times(CN1,C1))))),And(And(And(FreeQ($s("p"),$s("x")),Not(PowerQ($s("v")))),Not(PowerQ($s("w")))),Not(PowerQ($s("t")))))),
SetDelayed(Int(Times($p("u"),Times(Power($p("x"),$p("m",true)),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n")))),CN1))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("r"),Numerator(Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),$s("n")))),Set($s("s"),Denominator(Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),$s("n"))))),Dist(Times(Power($s("r"),Plus($s("m"),C1)),Power(Times(Times($s("a"),$s("n")),Power($s("s"),$s("m"))),CN1)),Sum(Int(Times($s("u"),Times(Power(CN1,Times(Times(C2,$s("k")),Times(Plus($s("m"),C1),Power($s("n"),CN1)))),Power(Plus(Times($s("r"),Power(CN1,Times(C2,Times($s("k"),Power($s("n"),CN1))))),Times(CN1,Times($s("s"),$s("x")))),CN1))),$s("x")),List($s("k"),C1,$s("n"))))),And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),IntegerQ(List($s("m"),$s("n")))),Less(Less(C0,$s("m")),$s("n"))),Not(AlgebraicFunctionQ($s("u"),$s("x")))))),
SetDelayed(Int(Times($p("u"),Power(Plus($p("a"),Times($p("b",true),Power($p("x"),$p("n")))),CN1)),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("r"),Numerator(Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),$s("n")))),Set($s("s"),Denominator(Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),$s("n"))))),Dist(Times($s("r"),Power(Times($s("a"),$s("n")),CN1)),Sum(Int(Times($s("u"),Times(Power(CN1,Times(C2,Times($s("k"),Power($s("n"),CN1)))),Power(Plus(Times($s("r"),Power(CN1,Times(C2,Times($s("k"),Power($s("n"),CN1))))),Times(CN1,Times($s("s"),$s("x")))),CN1))),$s("x")),List($s("k"),C1,$s("n"))))),And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),OddQ($s("n"))),Greater($s("n"),C1)),Not(AlgebraicFunctionQ($s("u"),$s("x")))))),
SetDelayed(Int(Times($p("u",true),Times(Power($p("v"),$p("m")),Power(Plus($p("a"),Times($p("b",true),Power($p("v"),$p("n")))),CN1))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("b"),$s("n")),CN1)),Sum(Int(Together(Times($s("u"),Power(Plus($s("v"),Times(CN1,Times(Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),$s("n")),Power(CN1,Times(C2,Times($s("k"),Power($s("n"),CN1))))))),CN1))),$s("x")),List($s("k"),C1,$s("n")))),And(And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),OddQ($s("n"))),Greater($s("n"),C1)),ZeroQ(Plus(Plus($s("m"),Times(CN1,$s("n"))),C1))),Not(And(AlgebraicFunctionQ($s("u"),$s("x")),AlgebraicFunctionQ($s("v"),$s("x"))))))),
SetDelayed(Int(Times($p("u",true),Power(Plus($p("a"),Times($p("b",true),Power($p("v"),$p("n")))),CN1)),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Times($s("a"),$s("n")),CN1)),Sum(Int(Together(Times($s("u"),Power(Plus(C1,Times(CN1,Times($s("v"),Power(Times(Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),$s("n")),Power(CN1,Times(C2,Times($s("k"),Power($s("n"),CN1))))),CN1)))),CN1))),$s("x")),List($s("k"),C1,$s("n")))),And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),OddQ($s("n"))),Greater($s("n"),C1)),Not(And(AlgebraicFunctionQ($s("u"),$s("x")),AlgebraicFunctionQ($s("v"),$s("x"))))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("v"),ExpnExpand($s("u"),$s("x")))),Condition(Int($s("v"),$s("x")),UnsameQ($s("v"),$s("u"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),SubstForInverseLinear($s("u"),$s("x")))),Condition(Times(CN1,Dist(Times(C1,Power(Part($s("lst"),C3),CN1)),Subst(Int(Times(Part($s("lst"),C1),Power(Power($s("x"),C2),CN1)),$s("x")),$s("x"),Times(C1,Power(Part($s("lst"),C2),CN1))))),NotFalseQ($s("lst"))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),FunctionOfLinear($s("u"),$s("x")))),Condition(Dist(Times(C1,Power(Part($s("lst"),C3),CN1)),Subst(Int(Part($s("lst"),C1),$s("x")),$s("x"),Plus(Part($s("lst"),C2),Times(Part($s("lst"),C3),$s("x"))))),Not(FalseQ($s("lst")))))),
SetDelayed(Int(Times($p("u",true),Power(Plus($p("a"),Times($p("b",true),Power($p("v"),$p("n")))),CN1)),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C2,Power(Times($s("a"),$s("n")),CN1)),Sum(Int(Together(Times($s("u"),Power(Plus(C1,Times(CN1,Times(Power($s("v"),C2),Power(Times(Rt(Times(Times(CN1,$s("a")),Power($s("b"),CN1)),Times($s("n"),C1D2)),Power(CN1,Times(C4,Times($s("k"),Power($s("n"),CN1))))),CN1)))),CN1))),$s("x")),List($s("k"),C1,Times($s("n"),C1D2)))),And(And(FreeQ(List($s("a"),$s("b")),$s("x")),EvenQ($s("n"))),Greater($s("n"),C2)))),
SetDelayed(Int(Times($p("u",true),Power(Plus($p("a"),Times($p("b",true),Power($p("v"),$p("n")))),$p("m"))),$p("x",$s("Symbol"))),
    Condition(Dist(Power($s("a"),$s("m")),Int(Times($s("u"),Product(Power(Plus(C1,Times(CN1,Times(Times(Power(CN1,Times(C4,Times($s("k"),Power($s("n"),CN1)))),Rt(Times(Times(CN1,$s("b")),Power($s("a"),CN1)),Times($s("n"),C1D2))),Power($s("v"),C2)))),$s("m")),List($s("k"),C1,Times($s("n"),C1D2)))),$s("x"))),And(And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),IntegerQ($s("m"))),Less($s("m"),CN1)),EvenQ($s("n"))),Greater($s("n"),C2)))),
SetDelayed(Int(Times($p("u",true),Power(Plus($p("a"),Times($p("b",true),Power($p("v"),$p("n")))),$p("m"))),$p("x",$s("Symbol"))),
    Condition(Dist(Power($s("a"),$s("m")),Int(Times($s("u"),Product(Power(Plus(C1,Times(Times(Power(CN1,Times(C2,Times($s("k"),Power($s("n"),CN1)))),Rt(Times($s("b"),Power($s("a"),CN1)),$s("n"))),$s("v"))),$s("m")),List($s("k"),C1,$s("n")))),$s("x"))),And(And(And(And(FreeQ(List($s("a"),$s("b")),$s("x")),IntegerQ($s("m"))),Less($s("m"),CN1)),OddQ($s("n"))),Greater($s("n"),C1)))),
SetDelayed(Int(Times($p("u",true),Power(Plus(Plus($p("a"),Times($p("b",true),$p("v"))),Times($p("c",true),$p("w"))),$p("m"))),$p("x",$s("Symbol"))),
    Condition(Dist(Times(C1,Power(Power(Times(C4,$s("c")),$s("m")),CN1)),Int(Times(Times($s("u"),Power(Plus(Plus($s("b"),Times(CN1,Sqrt(Plus(Power($s("b"),C2),Times(CN1,Times(Times(C4,$s("a")),$s("c"))))))),Times(Times(C2,$s("c")),$s("v"))),$s("m"))),Power(Plus(Plus($s("b"),Sqrt(Plus(Power($s("b"),C2),Times(CN1,Times(Times(C4,$s("a")),$s("c")))))),Times(Times(C2,$s("c")),$s("v"))),$s("m"))),$s("x"))),And(And(And(FreeQ(List($s("a"),$s("b"),$s("c")),$s("x")),IntegerQ($s("m"))),Less($s("m"),C0)),ZeroQ(Plus($s("w"),Times(CN1,Power($s("v"),C2))))))),
SetDelayed(Int($p("u"),$p("x",$s("Symbol"))),
    Module(List(Set($s("v"),NormalForm($s("u"),$s("x")))),Condition(Int($s("v"),$s("x")),Not(SameQ($s("v"),$s("u")))))),
SetDelayed(Int(Times($p("u",true),Power(Power($p("v"),$p("m")),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("q"),FractionalPart($s("p")))),Times(Times(Power(Power($s("v"),$s("m")),$s("q")),Power(Power($s("v"),Times($s("m"),$s("q"))),CN1)),Int(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),$s("x")))),And(FreeQ($s("m"),$s("x")),FractionQ($s("p"))))),
SetDelayed(Int(Times($p("u",true),Power(Times($p("a"),Power($p("v"),$p("m",true))),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("q"),FractionalPart($s("p")))),Times(Times(Power($s("a"),Plus($s("p"),Times(CN1,$s("q")))),Times(Power(Times($s("a"),Power($s("v"),$s("m"))),$s("q")),Power(Power($s("v"),Times($s("m"),$s("q"))),CN1))),Int(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),$s("x")))),And(FreeQ(List($s("a"),$s("m")),$s("x")),FractionQ($s("p"))))),
SetDelayed(Int(Times($p("u",true),Power(Times(Times($p("a",true),Power($p("v"),$p("m",true))),Power($p("w"),$p("n",true))),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("q"),FractionalPart($s("p")))),Times(Times(Power($s("a"),Plus($s("p"),Times(CN1,$s("q")))),Times(Power(Times(Times($s("a"),Power($s("v"),$s("m"))),Power($s("w"),$s("n"))),$s("q")),Power(Times(Power($s("v"),Times($s("m"),$s("q"))),Power($s("w"),Times($s("n"),$s("q")))),CN1))),Int(Times(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),Power($s("w"),Times($s("n"),$s("p")))),$s("x")))),And(FreeQ($s("a"),$s("x")),RationalQ(List($s("m"),$s("n"),$s("p")))))),
SetDelayed(Int(Times($p("u",true),Power(Power($p("v"),$p("m")),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Int(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),$s("x")),And(And(FreeQ($s("p"),$s("x")),Not(PowerQ($s("v")))),ZeroQ(Simplify(Plus(Power(Power($s("v"),$s("m")),$s("p")),Times(CN1,Power($s("v"),Times($s("m"),$s("p")))))))))),
SetDelayed(Int(Times($p("u",true),Power(Power($p("v"),$p("m")),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Module(List(Set($s("r"),Simplify(Times(Power(Power($s("v"),$s("m")),$s("p")),Power(Power($s("v"),Times($s("m"),$s("p"))),CN1))))),Condition(Times($s("r"),Int(Regularize(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),$s("x")),$s("x"))),NonzeroQ(Plus($s("r"),Times(CN1,C1))))),And(FreeQ($s("p"),$s("x")),Not(PowerQ($s("v")))))),
SetDelayed(Int(Times($p("u",true),Power(Times(Power($p("v"),$p("m",true)),Power($p("w"),$p("n",true))),$p("p"))),$p("x",$s("Symbol"))),
    Condition(Int(Times(Times($s("u"),Power($s("v"),Times($s("m"),$s("p")))),Power($s("w"),Times($s("n"),$s("p")))),$s("x")),And(And(And(FreeQ($s("p"),$s("x")),Not(PowerQ($s("v")))),Not(PowerQ($s("w")))),ZeroQ(Simplify(Plus(Power(Times(Power($s("v"),$s("m")),Power($s("w"),$s("n"))),$s("p")),Times(CN1,Times(Power($s("v"),Times($s("m"),$s("p"))),Power($s("w"),Times($s("n"),$s("p")))))))))))
  );
}
