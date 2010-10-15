function _sb(){}
function Vsb(){}
function VNc(){}
function uNc(){}
function LNc(){}
function QNc(){}
function NNc(b){this.b=b}
function BNc(){CNc.call(this,$Nc())}
function CNc(){DNc.call(this,Ioc(($Nc(),ZNc)))}
function $Nc(){$Nc=wad;ZNc=new DBb(lQd,7,7)}
function WNc(b){b.style[Jgd]=Kgd;b.style[Ngd]=uod;b.style[Qgd]=uod}
function UNc(b,c,d,e,f){b.style[Vgd]=e+vdd;c.style[Ogd]=e+vdd;d.style[Ogd]=f+vdd}
function ANc(b,c){var d;b.f=c;d=b.g[0];d.style[Vgd]=c;TNc(b.c,parseInt(d[qAd])||0)}
function yNc(b,c){FMc(b.P,Ccd,c);FMc(b.j,c,hQd);FMc(b.g[0],c,Ogd);FMc(b.g[1],c,Rgd)}
function $sb(){var b;while(Wsb){b=Wsb;Wsb=Wsb.c;!Wsb&&(Xsb=null);oDb(b.b.b,v0b())}}
function btb(){Ysb=new _sb;sB((pB(),oB),33);!!$stats&&$stats(jC(jRd,Mcd,-1,-1));Ysb.nd();!!$stats&&$stats(jC(jRd,Eyd,-1,-1))}
function TNc(b,c){var d,e,f,g;f=b.b.j;e=parseInt(b.b.b[qAd])||0;g=parseInt(f[qAd])||0;if(e<g){return}d=e-c-g;c<0?(c=0):d<0&&(c=e-g);UNc(b.b.g[0],f,b.b.g[1],c,c+g)}
function v0b(){var b,c,d,e;e=new BNc;yNc(e,kRd);e.P.style[Ugd]=UId;e.P.style[Vgd]=eQd;ANc(e,fQd);d=lRd;for(c=0;c<2;++c){d+=d}xzc(e,0,new Qtc(d));xzc(e,1,new Qtc(d));b=new Vsc;wv(b,e);return b}
function DNc(b){var c,d,e,f,g;zzc.call(this,(fF(),$doc).createElement(ycd),$doc.createElement(ycd),Fzc($doc.createElement(ycd)),Fzc($doc.createElement(ycd)));this.c=new VNc;this.b=Fzc($doc.createElement(ycd));e=this.g[0];c=this.g[1];d=this.j;this.P.appendChild(this.b);this.b.appendChild(e);this.b.appendChild(d);this.b.appendChild(c);d.innerHTML=mRd+POc(b.e,b.c,b.d,b.f,b.b)+_md||Ccd;e.style[Lgd]=kod;c.style[Lgd]=kod;this.P[pcd]=nRd;this.c.b=this;this.P.style[Jgd]=Sgd;g=this.g[0];f=this.g[1];WNc(g);WNc(f);WNc(this.j);Azc(this.b);f.style[Rgd]=uod;ANc(this,kQd)}
var mRd="<div class='vsplitter' style='text-align:center;'>",oRd='AsyncLoader33',lRd='This is some text to show how the contents on either side of the splitter flow. ',qRd='VerticalSplitPanel',rRd='VerticalSplitPanel$1',pRd='VerticalSplitPanel$Impl',kRd='cwVerticalSplitPanel',nRd='gwt-VerticalSplitPanel',jRd='runCallbacks33';_=_sb.prototype=Vsb.prototype=new Oq;_.gC=function atb(){return w4};_.nd=function etb(){$sb()};_.cM={};_=BNc.prototype=uNc.prototype=new rzc;_.gC=function ENc(){return Feb};_.wb=function FNc(b){yNc(this,b)};_.Ib=function GNc(){ANc(this,this.f);_kc(new NNc(this))};_.$e=function HNc(b,c){TNc(this.c,this.e+c-this.d)};_._e=function INc(b,c){this.d=c;this.e=parseInt(this.g[0][qAd])||0};_.Jb=function JNc(){};_.xb=function KNc(b){this.P.style[Vgd]=b};_.cM={13:1,14:1,16:1,17:1,85:1,87:1,124:1};_.b=null;_.d=0;_.e=0;_.f=null;_=NNc.prototype=LNc.prototype=new Oq;_._b=function ONc(){ANc(this.b,this.b.f)};_.gC=function PNc(){return Deb};_.cM={106:1};_.b=null;_=VNc.prototype=QNc.prototype=new Oq;_.gC=function XNc(){return Eeb};_.cM={};_.b=null;var ZNc=null;var w4=FXc(Ard,oRd),Eeb=FXc(ipd,pRd),Feb=FXc(ipd,qRd),Deb=FXc(ipd,rRd);$entry(btb)();