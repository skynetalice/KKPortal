function sDb(){}
function mDb(){}
function DHc(){}
function EHc(){EHc=fid;fXc()}
function fXc(){fXc=fid;eXc=hXc()>=7}
function tsc(b){qsc();!!psc&&kuc(psc,b)}
function GHc(b,c){dUc(b.b,mkd,c);dUc(b.N,c,J1d)}
function rbc(b,c){var d;d=new IHc(c,VKb(b));GHc(d,I1d+b.d);return d}
function IHc(b,c){EHc();JHc.call(this,oG($doc,ikd));this.b.innerText=b||mkd;this.c=c;this.b[GXd]=bmd+c}
function uDb(){pDb=new sDb;VB((SB(),RB),44);!!$stats&&$stats(MC(H1d,wkd,-1,-1));pDb.Qd();!!$stats&&$stats(MC(H1d,oHd,-1,-1))}
function hXc(){var b=-1;if(navigator.appName==L1d){var c=navigator.userAgent;var d=new RegExp(M1d);d.exec(c)!=null&&(b=parseFloat(RegExp.$1))}return b}
function JHc(b){this.b=oG($doc,oud);if(!b){this.N=this.b}else{this.N=b;this.N.appendChild(this.b)}this.J==-1?Krc(this.N,1|(this.N.__eventBits||0)):(this.J|=1);this.N[$jd]=K1d}
function rDb(){var b,c;while(nDb){b=nDb;nDb=nDb.c;!nDb&&(oDb=null);CJb(b.b.b,(c=new QUc,MUc(c,new UAc(G1d)),c.f[Dwd]=5,MUc(c,rbc(vfb,Ctd)),MUc(c,rbc(Hfb,Mtd)),MUc(c,rbc(ufb,wtd)),MUc(c,rbc(xfb,Etd)),MUc(c,rbc(Dfb,Itd)),MUc(c,rbc(Afb,Gtd)),c))}}
var G1d='<b>\u9009\u62E9\u4E00\u4E2A\u680F\u76EE\uFF1A<\/b>',N1d='AsyncLoader44',O1d='Hyperlink',M1d='MSIE ([0-9]{1,}[.0-9]{0,})',L1d='Microsoft Internet Explorer',I1d='cwHyperlink-',K1d='gwt-Hyperlink',H1d='runCallbacks44',J1d='wrapper';_=sDb.prototype=mDb.prototype=new nr;_.gC=function tDb(){return Fab};_.Qd=function xDb(){rDb()};_.cM={};_=IHc.prototype=DHc.prototype=new Cu;_.gC=function KHc(){return zib};_.Eb=function LHc(b){var c,d,e,f,g,i;qv(this,b);if(vtc(b.type)==1&&(f=b.button||0,c=!!b.ctrlKey,i=!!b.shiftKey,d=f==4,g=f==2,eXc?(e=i||c):(e=i),!e&&!d&&!g)){tsc(this.c);b.returnValue=false}};_.ub=function MHc(b){dUc(this.b,mkd,b);dUc(this.N,b,J1d)};_.cM={13:1,14:1,16:1,17:1,75:1,77:1};_.c=null;var eXc;var Fab=o3c(dAd,N1d),zib=o3c(Rxd,O1d);$entry(uDb)();