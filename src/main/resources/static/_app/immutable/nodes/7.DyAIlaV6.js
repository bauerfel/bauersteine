import{s as Ne,n as De,r as Ve,c as Ce,o as je}from"../chunks/scheduler.sluXByI4.js";import{S as Oe,i as Pe,e as o,s as b,c as i,l as Y,f as g,a as C,d,m as s,g as G,h as t,n as Z,o as le,u as be,q as qe,k as ye,t as ue,b as ce,j as de}from"../chunks/index.BQQS3HTZ.js";import{e as Be}from"../chunks/each.D6YF6ztN.js";import{j as Me,m as Se,a as me}from"../chunks/store.C8kMcS5N.js";import{p as He}from"../chunks/stores.PAL8E2NE.js";function Ie(l,e,n){const a=l.slice();return a[2]=e[n],a}function Le(l){let e,n,a=l[2].beschreibung+"",u,y,h,_=l[2].material+"",T,z,U,P=l[2].preis+"",N,V,D,R=l[2].inhaltsmenge+"",X,B,F,c=l[2].state+"",p,I,W,J=l[2].id+"",L,x,O,q,A,M,ne="X",j,$,S,E=l[2].state==="SOLD"&&Ae(l);function re(){return l[11](l[2])}return{c(){e=o("tr"),n=o("td"),u=ue(a),y=b(),h=o("td"),T=ue(_),z=b(),U=o("td"),N=ue(P),V=b(),D=o("td"),X=ue(R),B=b(),F=o("td"),p=ue(c),I=b(),W=o("td"),L=ue(J),x=b(),O=o("td"),E&&E.c(),q=b(),A=o("td"),M=o("button"),M.textContent=ne,j=b(),this.h()},l(w){e=i(w,"TR",{});var f=C(e);n=i(f,"TD",{});var ee=C(n);u=ce(ee,a),ee.forEach(d),y=g(f),h=i(f,"TD",{});var H=C(h);T=ce(H,_),H.forEach(d),z=g(f),U=i(f,"TD",{});var K=C(U);N=ce(K,P),K.forEach(d),V=g(f),D=i(f,"TD",{});var fe=C(D);X=ce(fe,R),fe.forEach(d),B=g(f),F=i(f,"TD",{});var se=C(F);p=ce(se,c),se.forEach(d),I=g(f),W=i(f,"TD",{});var Q=C(W);L=ce(Q,J),Q.forEach(d),x=g(f),O=i(f,"TD",{});var ae=C(O);E&&E.l(ae),ae.forEach(d),q=g(f),A=i(f,"TD",{});var oe=C(A);M=i(oe,"BUTTON",{type:!0,class:!0,"data-svelte-h":!0}),Y(M)!=="svelte-1aqgjdw"&&(M.textContent=ne),j=g(oe),oe.forEach(d),f.forEach(d),this.h()},h(){s(M,"type","button"),s(M,"class","btn btn-danger")},m(w,f){G(w,e,f),t(e,n),t(n,u),t(e,y),t(e,h),t(h,T),t(e,z),t(e,U),t(U,N),t(e,V),t(e,D),t(D,X),t(e,B),t(e,F),t(F,p),t(e,I),t(e,W),t(W,L),t(e,x),t(e,O),E&&E.m(O,null),t(e,q),t(e,A),t(A,M),t(A,j),$||(S=le(M,"click",re),$=!0)},p(w,f){l=w,f&1&&a!==(a=l[2].beschreibung+"")&&de(u,a),f&1&&_!==(_=l[2].material+"")&&de(T,_),f&1&&P!==(P=l[2].preis+"")&&de(N,P),f&1&&R!==(R=l[2].inhaltsmenge+"")&&de(X,R),f&1&&c!==(c=l[2].state+"")&&de(p,c),f&1&&J!==(J=l[2].id+"")&&de(L,J),l[2].state==="SOLD"?E?E.p(l,f):(E=Ae(l),E.c(),E.m(O,null)):E&&(E.d(1),E=null)},d(w){w&&d(e),E&&E.d(),$=!1,S()}}}function Ae(l){let e,n="X",a,u;function y(){return l[10](l[2])}return{c(){e=o("button"),e.textContent=n,this.h()},l(h){e=i(h,"BUTTON",{type:!0,class:!0,"data-svelte-h":!0}),Y(e)!=="svelte-15q4dvp"&&(e.textContent=n),this.h()},h(){s(e,"type","button"),s(e,"class","btn btn-secondary")},m(h,_){G(h,e,_),a||(u=le(e,"click",y),a=!0)},p(h,_){l=h},d(h){h&&d(e),a=!1,u()}}}function we(l){let e,n=l[2].userEmail===l[1]&&Le(l);return{c(){n&&n.c(),e=ye()},l(a){n&&n.l(a),e=ye()},m(a,u){n&&n.m(a,u),G(a,e,u)},p(a,u){a[2].userEmail===a[1]?n?n.p(a,u):(n=Le(a),n.c(),n.m(e.parentNode,e)):n&&(n.d(1),n=null)},d(a){a&&d(e),n&&n.d(a)}}}function ze(l){let e,n="Create Urne",a,u,y,h,_,T="Beschreibung",z,U,P,N,V,D,R="Material",X,B,F,c,p,I,W="Preis",J,L,x,O,q,A,M="Inhaltsmenge in Liter",ne,j,$,S,E="Submit",re,w,f="Alle Urnen",ee,H,K,fe='<tr><th scope="col">Beschreibung</th> <th scope="col">Material</th> <th scope="col">Preis</th> <th scope="col">Inhaltsmenge</th> <th scope="col">State</th> <th scope="col">UrneId</th> <th scope="col">Deliver</th> <th scope="col">Delete</th></tr>',se,Q,ae,oe,ie=Be(l[0]),k=[];for(let r=0;r<ie.length;r+=1)k[r]=we(Ie(l,ie,r));return{c(){e=o("h1"),e.textContent=n,a=b(),u=o("form"),y=o("div"),h=o("div"),_=o("label"),_.textContent=T,z=b(),U=o("input"),P=b(),N=o("div"),V=o("div"),D=o("label"),D.textContent=R,X=b(),B=o("input"),F=b(),c=o("div"),p=o("div"),I=o("label"),I.textContent=W,J=b(),L=o("input"),x=b(),O=o("div"),q=o("div"),A=o("label"),A.textContent=M,ne=b(),j=o("input"),$=b(),S=o("button"),S.textContent=E,re=b(),w=o("h1"),w.textContent=f,ee=b(),H=o("table"),K=o("thead"),K.innerHTML=fe,se=b(),Q=o("tbody");for(let r=0;r<k.length;r+=1)k[r].c();this.h()},l(r){e=i(r,"H1",{class:!0,"data-svelte-h":!0}),Y(e)!=="svelte-1ejq1pq"&&(e.textContent=n),a=g(r),u=i(r,"FORM",{class:!0});var v=C(u);y=i(v,"DIV",{class:!0});var m=C(y);h=i(m,"DIV",{class:!0});var te=C(h);_=i(te,"LABEL",{class:!0,for:!0,"data-svelte-h":!0}),Y(_)!=="svelte-1v2o3yp"&&(_.textContent=T),z=g(te),U=i(te,"INPUT",{class:!0,id:!0,type:!0}),te.forEach(d),m.forEach(d),P=g(v),N=i(v,"DIV",{class:!0});var Ee=C(N);V=i(Ee,"DIV",{class:!0});var he=C(V);D=i(he,"LABEL",{class:!0,for:!0,"data-svelte-h":!0}),Y(D)!=="svelte-3mgonx"&&(D.textContent=R),X=g(he),B=i(he,"INPUT",{class:!0,id:!0,type:!0}),he.forEach(d),Ee.forEach(d),F=g(v),c=i(v,"DIV",{class:!0});var Te=C(c);p=i(Te,"DIV",{class:!0});var pe=C(p);I=i(pe,"LABEL",{class:!0,for:!0,"data-svelte-h":!0}),Y(I)!=="svelte-1gu7mj6"&&(I.textContent=W),J=g(pe),L=i(pe,"INPUT",{class:!0,id:!0,type:!0}),pe.forEach(d),Te.forEach(d),x=g(v),O=i(v,"DIV",{class:!0});var Ue=C(O);q=i(Ue,"DIV",{class:!0});var ve=C(q);A=i(ve,"LABEL",{class:!0,for:!0,"data-svelte-h":!0}),Y(A)!=="svelte-dnlvk5"&&(A.textContent=M),ne=g(ve),j=i(ve,"INPUT",{class:!0,id:!0,type:!0}),ve.forEach(d),Ue.forEach(d),$=g(v),S=i(v,"BUTTON",{type:!0,class:!0,"data-svelte-h":!0}),Y(S)!=="svelte-foyvn1"&&(S.textContent=E),v.forEach(d),re=g(r),w=i(r,"H1",{"data-svelte-h":!0}),Y(w)!=="svelte-1kptfke"&&(w.textContent=f),ee=g(r),H=i(r,"TABLE",{class:!0});var _e=C(H);K=i(_e,"THEAD",{"data-svelte-h":!0}),Y(K)!=="svelte-bgtfuv"&&(K.innerHTML=fe),se=g(_e),Q=i(_e,"TBODY",{});var ke=C(Q);for(let ge=0;ge<k.length;ge+=1)k[ge].l(ke);ke.forEach(d),_e.forEach(d),this.h()},h(){s(e,"class","mt-3"),s(_,"class","form-label"),s(_,"for","description"),s(U,"class","form-control"),s(U,"id","description"),s(U,"type","text"),s(h,"class","col"),s(y,"class","row mb-3"),s(D,"class","form-label"),s(D,"for","description"),s(B,"class","form-control"),s(B,"id","description"),s(B,"type","text"),s(V,"class","col"),s(N,"class","row mb-3"),s(I,"class","form-label"),s(I,"for","earnings"),s(L,"class","form-control"),s(L,"id","earnings"),s(L,"type","number"),s(p,"class","col"),s(c,"class","row mb-3"),s(A,"class","form-label"),s(A,"for","earnings"),s(j,"class","form-control"),s(j,"id","earnings"),s(j,"type","number"),s(q,"class","col"),s(O,"class","row mb-3"),s(S,"type","button"),s(S,"class","btn btn-primary"),s(u,"class","mb-5"),s(H,"class","table")},m(r,v){G(r,e,v),G(r,a,v),G(r,u,v),t(u,y),t(y,h),t(h,_),t(h,z),t(h,U),Z(U,l[2].beschreibung),t(u,P),t(u,N),t(N,V),t(V,D),t(V,X),t(V,B),Z(B,l[2].material),t(u,F),t(u,c),t(c,p),t(p,I),t(p,J),t(p,L),Z(L,l[2].preis),t(u,x),t(u,O),t(O,q),t(q,A),t(q,ne),t(q,j),Z(j,l[2].inhaltsmenge),t(u,$),t(u,S),G(r,re,v),G(r,w,v),G(r,ee,v),G(r,H,v),t(H,K),t(H,se),t(H,Q);for(let m=0;m<k.length;m+=1)k[m]&&k[m].m(Q,null);ae||(oe=[le(U,"input",l[6]),le(B,"input",l[7]),le(L,"input",l[8]),le(j,"input",l[9]),le(S,"click",l[3])],ae=!0)},p(r,[v]){if(v&4&&U.value!==r[2].beschreibung&&Z(U,r[2].beschreibung),v&4&&B.value!==r[2].material&&Z(B,r[2].material),v&4&&be(L.value)!==r[2].preis&&Z(L,r[2].preis),v&4&&be(j.value)!==r[2].inhaltsmenge&&Z(j,r[2].inhaltsmenge),v&51){ie=Be(r[0]);let m;for(m=0;m<ie.length;m+=1){const te=Ie(r,ie,m);k[m]?k[m].p(te,v):(k[m]=we(te),k[m].c(),k[m].m(Q,null))}for(;m<k.length;m+=1)k[m].d(1);k.length=ie.length}},i:De,o:De,d(r){r&&(d(e),d(a),d(u),d(re),d(w),d(ee),d(H)),qe(k,r),ae=!1,Ve(oe)}}}function Re(l,e,n){let a,u,y;Ce(l,Me,c=>n(12,a=c)),Ce(l,He,c=>n(13,u=c)),Ce(l,Se,c=>n(1,y=c));const h=u.url.origin;let _=[],T={beschreibung:"",material:"",preis:0,inhaltsmenge:0};je(()=>{z()});function z(){var c={method:"get",url:h+"/api/urne",headers:{},headers:{Authorization:"Bearer "+a}};me(c).then(function(p){n(0,_=p.data)}).catch(function(p){alert("Could not get Urnen"),console.log(p)})}function U(){var c={method:"post",url:h+"/api/urne",headers:{Authorization:"Bearer "+a},data:T};me(c).then(function(p){alert("Urne created"),z()}).catch(function(p){alert("Could not create Urne"),console.log(p)})}function P(c){var p={method:"delete",url:h+"/api/urne/"+c,headers:{Authorization:"Bearer "+a}};me(p).then(function(I){alert("Urne deleted"),z()}).catch(function(I){alert("Could not delete Urne"),console.log(I)})}async function N(c){try{const p=await me.post(`${h}/api/service/${c}/deliverUrne`,{},{headers:{Authorization:"Bearer "+a}});alert("Urne delivered")}catch(p){alert("Could not set Urne to delivered"),console.log(p)}}function V(){T.beschreibung=this.value,n(2,T)}function D(){T.material=this.value,n(2,T)}function R(){T.preis=be(this.value),n(2,T)}function X(){T.inhaltsmenge=be(this.value),n(2,T)}return[_,y,T,U,P,N,V,D,R,X,c=>{N(c.id)},c=>{P(c.id)}]}class Ke extends Oe{constructor(e){super(),Pe(this,e,Re,ze,Ne,{})}}export{Ke as component};