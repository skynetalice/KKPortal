function Vob(){}
function Pob(){}
function G$b(){}
function L$b(){}
function G1c(){}
function Y1c(){}
function n2c(){}
function u2c(){}
function N$b(b){this.b=b}
function I$b(b){this.b=b}
function p2c(b){this.b=b}
function x2c(b){this.d=b;this.c=b.b.c.b}
function j2c(b){b.b.c=b.c;b.c.b=b.b;b.b=b.c=null}
function N1c(b,c){if(b.b){j2c(c);i2c(c)}}
function D$b(b){BCb(b.c,k$b(b.b))}
function l2c(b,c,d){this.d=b;this.e=c;this.f=d;this.b=this.c=null}
function k2c(b){this.d=b;this.e=null;this.f=null;this.b=this.c=null}
function O1c(){hYc(this);this.c=new k2c(this);this.d=new l1c;this.c.c=this.c;this.c.b=this.c}
function w2c(b){if(b.c==b.d.b.c){throw new M2c}b.b=b.c;b.c=b.c.b;return b.b}
function i2c(b){var c;c=b.d.c.c;b.c=c;b.b=b.d.c;c.b=b.d.c.c=b}
function L1c(b,c){var d;d=q0(b.d.ad(c),132);if(d){N1c(b,d);return d.f}return null}
function Flc(b,c,d,e){var f;mt(c);f=b.g.d;b.Ae(c,d,e);wlc(b,c,b.P,f,true)}
function Uob(){var b;while(Qob){b=Qob;Qob=Qob.c;!Qob&&(Rob=null);D$b(b.b)}}
function JEb(b){var c,d;c=q0(b.b.ad(UGd),74);if(c==null){d=b0(lhb,521,{15:1,74:1},1,[VGd,otd,Iod]);b.b.bd(UGd,d);return d}else{return c}}
function M1c(b,c,d){var e,f,g;f=q0(b.d.ad(c),132);if(!f){e=new l2c(b,c,d);b.d.bd(c,e);i2c(e);return null}else{g=f.f;b2c(f,d);N1c(b,f);return g}}
function j$b(b){var c,d,e,f,g,i,j,k,n,o,p,q;e=new xtc;b.f=new cAc;b.f.P.style[B6c]=WGd;Rzc(b.f,XGd);b.d=new cAc;b.d.P.style[B6c]=WGd;Rzc(b.d,YGd);b.e=new xxc;e.Le(0,0);g=(i=e.k.b.j.rows[0].cells[0],dtc(e,i,false),i);g.innerHTML=ZGd;ntc(e,0,1,b.e);e.Le(1,0);j=(k=e.k.b.j.rows[1].cells[0],dtc(e,k,false),k);j.innerHTML=$Gd;ntc(e,1,1,b.f);e.Le(2,0);n=(o=e.k.b.j.rows[2].cells[0],dtc(e,o,false),o);n.innerHTML=_Gd;ntc(e,2,1,b.d);for(d=(p=BX(b.g).c.Ib(),new n$c(p));d.b.nc();){c=q0((q=q0(d.b.oc(),18),q.jd()),1);sxc(b.e,c)}ct(b.e,new I$b(b),(wJ(),wJ(),vJ));f=new N$b(b);ct(b.f,f,(jL(),jL(),iL));ct(b.d,f,iL);return e}
function Xob(){Sob=new Vob;wy((ty(),sy),24);!!$stats&&$stats(nz(TGd,U6c,-1,-1));Sob.Ad();!!$stats&&$stats(nz(TGd,oqd,-1,-1))}
function k$b(b){var c,d,e,f,g,i,j,k,n,o,p,r;b.g=new O1c;b.b=new Mlc;Is(b.b,qGd,qGd);b.b.qb(rGd);k=JEb(b.c);j=new nqc(aHd);Flc(b.b,j,10,20);M1c(b.g,k[0],j);d=new ymc(bHd);Flc(b.b,d,80,45);M1c(b.g,k[1],d);e=new huc(2,3);e.p[Pcd]=bhd;for(f=0;f<3;++f){e.Le(0,f);n=(o=e.k.b.j.rows[0].cells[f],dtc(e,o,f+z6c==null),o);f+z6c!=null&&(n.innerHTML=f+z6c||z6c,undefined);ntc(e,1,f,new Owc((QCb(),$Fb(),WFb)))}Flc(b.b,e,60,100);M1c(b.g,k[2],e);c=new rpc;Pt(c,b.b);i=new rpc;Pt(i,j$b(b));g=new Evc;g.f[S9c]=10;p=zvc(g);g.c.appendChild(p);mt(i);eJc(g.g,i);p.appendChild(i.P);ot(i,g);r=zvc(g);g.c.appendChild(r);mt(c);eJc(g.g,c);r.appendChild(c.P);ot(c,g);return g}
function l$b(c){var b,e,f,g,i;g=rxc(c.e,c.e.P.selectedIndex);e=q0(L1c(c.g,g),62);try{i=lTc(KB(c.f.P,rsd));f=lTc(KB(c.d.P,rsd));Klc(c.b,e,f,i)}catch(b){b=yhb(b);if(t0(b,75)){return}else throw b}}
var XGd='100',WGd='3em',YGd='60',$Gd='<b>Bord du dessus:<\/b>',_Gd='<b>Bord gauche:<\/b>',ZGd='<b>Points \xE0 circuler:<\/b>',dHd='AsyncLoader24',VGd='Bonjour le monde',bHd='Cliquez-moi!',eHd='CwAbsolutePanel$3',fHd='CwAbsolutePanel$4',aHd='Hello World',gHd='LinkedHashMap',hHd='LinkedHashMap$ChainEntry',iHd='LinkedHashMap$EntrySet',jHd='LinkedHashMap$EntrySet$EntryIterator',cHd='No current entry',UGd='cwAbsolutePanelWidgetNames',TGd='runCallbacks24';_=Vob.prototype=Pob.prototype=new bq;_.gC=function Wob(){return E4};_.Ad=function $ob(){Uob()};_.tI=0;_.cM={};_=I$b.prototype=G$b.prototype=new bq;_.gC=function J$b(){return r9};_.cc=function K$b(b){m$b(this.b)};_.tI=231;_.cM={21:1,71:1};_.b=null;_=N$b.prototype=L$b.prototype=new bq;_.gC=function O$b(){return s9};_.fc=function P$b(b){l$b(this.b)};_.tI=232;_.cM={27:1,71:1};_.b=null;_=O1c.prototype=G1c.prototype=new j1c;_.pf=function P1c(){this.d.pf();this.c.c=this.c;this.c.b=this.c};_.Zc=function Q1c(b){return this.d.Zc(b)};_.$c=function R1c(b){var c;c=this.c.b;while(c!=this.c){if(F4c(c.f,b)){return true}c=c.b}return false};_._c=function S1c(){return new p2c(this)};_.ad=function T1c(b){return L1c(this,b)};_.gC=function U1c(){return wgb};_.bd=function V1c(b,c){return M1c(this,b,c)};_.tf=function W1c(b){var c;c=q0(this.d.tf(b),132);if(c){j2c(c);return c.f}return null};_.cd=function X1c(){return this.d.cd()};_.tI=468;_.cM={15:1,93:1};_.b=false;_=l2c.prototype=k2c.prototype=Y1c.prototype=new Z1c;_.gC=function m2c(){return tgb};_.tI=470;_.cM={18:1,132:1};_.b=null;_.c=null;_.d=null;_=p2c.prototype=n2c.prototype=new ZX;_.fd=function q2c(b){var c,d,e;if(!(b!=null&&b.tI&&!!b.cM[18])){return false}c=q0(b,18);d=c.jd();if(this.b.d.Zc(d)){e=L1c(this.b,d);return F4c(c.kc(),e)}return false};_.gC=function r2c(){return vgb};_.Ib=function s2c(){return new x2c(this)};_.cd=function t2c(){return this.b.d.cd()};_.tI=471;_.cM={102:1,113:1};_.b=null;_=x2c.prototype=u2c.prototype=new bq;_.gC=function y2c(){return ugb};_.nc=function z2c(){return this.c!=this.d.b.c};_.oc=function A2c(){return w2c(this)};_.pc=function B2c(){if(!this.b){throw new ATc(cHd)}j2c(this.b);this.d.b.d.tf(this.b.e);this.b=null};_.tI=0;_.cM={};_.b=null;_.c=null;_.d=null;var E4=VSc(dkd,dHd),r9=VSc(Rmd,eHd),s9=VSc(Rmd,fHd),wgb=VSc(Ojd,gHd),tgb=VSc(Ojd,hHd),vgb=VSc(Ojd,iHd),ugb=VSc(Ojd,jHd);$entry(Xob)();