function mail(){var O='',sb='" for "gwt:onLoadErrorFn"',qb='" for "gwt:onPropertyErrorFn"',_='"><\/script>',bb='#',Rb='.cache.html',db='/',Kb='0889807CD811F7C5A646C646228E30E0',Lb='727177B371EC091386368B9E4427E2F1',Mb='844DE66BF55461D5A1EDD7D87394CDEF',Nb='8A0677C34F4BAB2A9DE4B486F66B4848',Qb=':',kb='::',Tb='<script defer="defer">mail.onInjectionDone(\'mail\')<\/script>',$='<script id="',nb='=',cb='?',pb='Bad handler "',Sb='DOMContentLoaded',Ob='F6D850D81528DD21838654C7716658D0',Pb='F91606A44B1C7B866E2DC53D428E7B8A',ab='SCRIPT',Y='__gwt_marker_mail',eb='base',Z='baseUrl',S='begin',R='bootstrap',gb='clear.cache.gif',mb='content',X='end',Eb='gecko',Fb='gecko1_8',T='gwt.codesvr=',U='gwt.hosted=',V='gwt.hybrid',rb='gwt:onLoadErrorFn',ob='gwt:onPropertyErrorFn',lb='gwt:property',Ib='hosted.html?mail',Db='ie6',Cb='ie8',tb='iframe',fb='img',ub="javascript:''",Hb='loadExternalRefs',P='mail',jb='mail::',hb='meta',wb='moduleRequested',W='moduleStartup',Bb='msie',ib='name',yb='opera',vb='position:absolute;width:0;height:0;border:none',Ab='safari',Jb='selectingPermutation',Q='startup',Gb='unknown',xb='user.agent',zb='webkit';var k=window,l=document,m=k.__gwtStatsEvent?function(a){return k.__gwtStatsEvent(a)}:null,n=k.__gwtStatsSessionId?k.__gwtStatsSessionId:null,o,p,q,r=O,s={},t=[],u=[],v=[],w=0,x,y;m&&m({moduleName:P,sessionId:n,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:S});if(!k.__gwt_stylesLoaded){k.__gwt_stylesLoaded={}}if(!k.__gwt_scriptsLoaded){k.__gwt_scriptsLoaded={}}function z(){var b=false;try{var c=k.location.search;return (c.indexOf(T)!=-1||(c.indexOf(U)!=-1||k.external&&k.external.gwtOnLoad))&&c.indexOf(V)==-1}catch(a){}z=function(){return b};return b}
function A(){if(o&&p){var b=l.getElementById(P);var c=b.contentWindow;if(z()){c.__gwt_getProperty=function(a){return G(a)}}mail=null;c.gwtOnLoad(x,P,r,w);m&&m({moduleName:P,sessionId:n,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:X})}}
function B(){var e,f=Y,g;if(s[Z]){r=s[Z];return}l.write($+f+_);g=l.getElementById(f);e=g&&g.previousSibling;while(e&&e.tagName!=ab){e=e.previousSibling}function h(a){var b=a.lastIndexOf(bb);if(b==-1){b=a.length}var c=a.indexOf(cb);if(c==-1){c=a.length}var d=a.lastIndexOf(db,Math.min(c,b));return d>=0?a.substring(0,d+1):O}
;if(e&&e.src){r=h(e.src)}if(r==O){var i=l.getElementsByTagName(eb);if(i.length>0){r=i[i.length-1].href}else{r=h(l.location.href)}}else if(r.match(/^\w+:\/\//)){}else{var j=l.createElement(fb);j.src=r+gb;r=h(j.src)}if(g){g.parentNode.removeChild(g)}}
function C(){var b=document.getElementsByTagName(hb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(ib),g;if(f){f=f.replace(jb,O);if(f.indexOf(kb)>=0){continue}if(f==lb){g=e.getAttribute(mb);if(g){var h,i=g.indexOf(nb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=O}s[f]=h}}else if(f==ob){g=e.getAttribute(mb);if(g){try{y=eval(g)}catch(a){alert(pb+g+qb)}}}else if(f==rb){g=e.getAttribute(mb);if(g){try{x=eval(g)}catch(a){alert(pb+g+sb)}}}}}}
function F(a,b){var c=v;for(var d=0,e=a.length-1;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
function G(a){var b=u[a](),c=t[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(y){y(a,d,b)}throw null}
var H;function I(){if(!H){H=true;var a=l.createElement(tb);a.src=ub;a.id=P;a.style.cssText=vb;a.tabIndex=-1;l.body.appendChild(a);m&&m({moduleName:P,sessionId:n,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:wb});a.contentWindow.location.replace(r+K)}}
u[xb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(b.indexOf(yb)!=-1){return yb}else if(b.indexOf(zb)!=-1){return Ab}else if(b.indexOf(Bb)!=-1){if(document.documentMode>=8){return Cb}else{var d=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){var e=c(d);if(e>=6000){return Db}}}}else if(b.indexOf(Eb)!=-1){var d=/rv:([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){if(c(d)>=1008)return Fb}return Eb}return Gb};t[xb]={gecko:0,gecko1_8:1,ie6:2,ie8:3,opera:4,safari:5};mail.onScriptLoad=function(){if(H){p=true;A()}};mail.onInjectionDone=function(){o=true;m&&m({moduleName:P,sessionId:n,subSystem:Q,evtGroup:Hb,millis:(new Date).getTime(),type:X});A()};C();B();var J;var K;if(z()){if(k.external&&(k.external.initModule&&k.external.initModule(P))){k.location.reload();return}K=Ib;J=O}m&&m({moduleName:P,sessionId:n,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:Jb});if(!z()){try{F([Cb],Kb);F([yb],Lb);F([Fb],Mb);F([Eb],Nb);F([Db],Ob);F([Ab],Pb);J=v[G(xb)];var L=J.indexOf(Qb);if(L!=-1){w=Number(J.substring(L+1));J=J.substring(0,L)}K=J+Rb}catch(a){return}}var M;function N(){if(!q){q=true;A();if(l.removeEventListener){l.removeEventListener(Sb,N,false)}if(M){clearInterval(M)}}}
if(l.addEventListener){l.addEventListener(Sb,function(){I();N()},false)}var M=setInterval(function(){if(/loaded|complete/.test(l.readyState)){I();N()}},50);m&&m({moduleName:P,sessionId:n,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:X});m&&m({moduleName:P,sessionId:n,subSystem:Q,evtGroup:Hb,millis:(new Date).getTime(),type:S});l.write(Tb)}
mail();