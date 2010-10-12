function cR(){}
function Mdb(){}
function Gdb(){}
function eR(){eR=DZc;dR=new iWc}
function noc(b,c,d){(b.b.be(c),b.b.j.rows[c])[s_c]=d}
function oR(b){throw new FXc(Bjd+b+Nrd)}
function fR(e,b){var c=e.b;for(var d in c){c.hasOwnProperty(d)&&b.zc(d)}}
function hR(e,b){b=String(b);var c=e.b;var d=c[b];(d==null||!c.hasOwnProperty(b))&&e.sc(b);return String(d)}
function gR(d,c){try{typeof $wnd[c]!=Jrd&&oR(c);d.b=$wnd[c]}catch(b){oR(c)}}
function kR(){this.c=Krd;gR(this,Lrd);if(!this.b){throw new FXc(Mrd)}}
function mR(){eR();var b;b=wW(dR.wc(Lrd),78);if(!b){b=new kR;dR.xc(Lrd,b)}return b}
function Odb(){Jdb=new Mdb;Zx((Wx(),Vx),12);!!$stats&&$stats(Qy(Rrd,R_c,-1,-1));Jdb.Qc();!!$stats&&$stats(Qy(Rrd,$id,-1,-1))}
function Ldb(){var b;while(Hdb){b=Hdb;Hdb=Hdb.c;!Hdb&&(Idb=null);iwb(b.b.b,LNb())}}
function LNb(){var b,c,d,e,f,g,i,j,k,p,q,r,s,t,u,v;f=new YBc;g=new Gjc(Srd);g.N.dir=h1c;g.N.style[b3c]=c3c;UBc(f,new Gjc(Trd));UBc(f,g);j=new Zmc;i=mR();e=(p=new uWc,fR(i,p),p);b=0;for(d=(q=CS(e.b).c.Gb(),new kTc(q));d.b.Ec();){c=wW((r=wW(d.b.Fc(),18),r.Hc()),1);k=hR(i,c);j.ae(0,b);s=(t=j.k.b.j.rows[0].cells[b],Fmc(j,t,c==null),t);c!=null&&(s.innerHTML=c||w_c,undefined);j.ae(1,b);u=(v=j.k.b.j.rows[1].cells[b],Fmc(j,v,k==null),v);k!=null&&(u.innerHTML=k||w_c,undefined);++b}noc(j.o,0,Urd);noc(j.o,1,Vrd);UBc(f,new Gjc(Wrd));UBc(f,j);return f}
var Qrd='\n keys found: ',Prd="' in ",Nrd="' is not a JavaScript object and cannot be used as a Dictionary",Trd='<b>This example interacts with the following JavaScript variable:<\/b>',Wrd='<br><br>',Srd='<pre>var userInfo = {\n&nbsp;&nbsp;name: "Amelie Crutcher",\n&nbsp;&nbsp;timeZone: "EST",\n&nbsp;&nbsp;userID: "123",\n&nbsp;&nbsp;lastLogOn: "2/2/2006"\n};<\/pre>\n',Xrd='AsyncLoader12',Ord="Cannot find '",Mrd="Cannot find JavaScript object with the name 'userInfo'",Krd='Dictionary userInfo',Vrd='cw-DictionaryExample-dataRow',Urd='cw-DictionaryExample-headerRow',Jrd='object',Rrd='runCallbacks12',Lrd='userInfo';_=kR.prototype=cR.prototype=new Ep;_.gC=function lR(){return aZ};_.sc=function nR(b){var c,d,e;d=(e=new uWc,fR(this,e),e);c=Ord+b+Prd+this;d.b.yc()<20&&(c+=Qrd+d);throw new FXc(c)};_.tS=function pR(){return this.c};_.tI=72;_.cM={78:1};_.b=null;_.c=null;var dR;_=Mdb.prototype=Gdb.prototype=new Ep;_.gC=function Ndb(){return EZ};_.Qc=function Rdb(){Ldb()};_.tI=0;_.cM={};var aZ=SLc(Kcd,M6c),EZ=SLc(Tcd,Xrd);$entry(Odb)();