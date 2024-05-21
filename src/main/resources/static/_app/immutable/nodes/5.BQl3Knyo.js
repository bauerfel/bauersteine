import{s as rt,n as F,c as tt,o as ot}from"../chunks/scheduler.sluXByI4.js";import{S as st,i as it,e as g,s as D,c as b,l as R,f as y,a as T,d as p,m as at,g as I,h as c,q as ct,t as j,b as w,j as B,o as ht}from"../chunks/index.Vlo5ODvd.js";import{e as et}from"../chunks/each.D6YF6ztN.js";import{a as z}from"../chunks/axios.B6xwUs71.js";import{p as dt}from"../chunks/stores.B1E5GMEr.js";import{j as ut}from"../chunks/store.cIuNT0ob.js";function nt(o,t,h){const n=o.slice();return n[2]=t[h],n}function ft(o){let t,h="Zu meiner Bestellung hinzufügen",n,s;function f(){return o[3](o[2])}return{c(){t=g("button"),t.textContent=h},l(d){t=b(d,"BUTTON",{"data-svelte-h":!0}),R(t)!=="svelte-18tcbby"&&(t.textContent=h)},m(d,_){I(d,t,_),n||(s=ht(t,"click",f),n=!0)},p(d,_){o=d},d(d){d&&p(t),n=!1,s()}}}function pt(o){let t,h="Ausverkauft";return{c(){t=g("span"),t.textContent=h,this.h()},l(n){t=b(n,"SPAN",{class:!0,"data-svelte-h":!0}),R(t)!=="svelte-844lc3"&&(t.textContent=h),this.h()},h(){at(t,"class","badge bg-secondary")},m(n,s){I(n,t,s)},p:F,d(n){n&&p(t)}}}function lt(o){let t,h,n=o[2].beschreibung+"",s,f,d,_=o[2].material+"",v,k,i,e=o[2].preis+"",l,r,m,C=o[2].inhaltsmenge+"",S,A,O,L=o[2].state+"",H,$,M,N=o[2].id+"",P,G,U,J;function V(u,a){return u[2].state==="ASSIGNED"||u[2].state==="SOLD"||u[2].state==="DELIVERED"?pt:ft}let q=V(o),E=q(o);return{c(){t=g("tr"),h=g("td"),s=j(n),f=D(),d=g("td"),v=j(_),k=D(),i=g("td"),l=j(e),r=D(),m=g("td"),S=j(C),A=D(),O=g("td"),H=j(L),$=D(),M=g("td"),P=j(N),G=D(),U=g("td"),E.c(),J=D()},l(u){t=b(u,"TR",{});var a=T(t);h=b(a,"TD",{});var Y=T(h);s=w(Y,n),Y.forEach(p),f=y(a),d=b(a,"TD",{});var Z=T(d);v=w(Z,_),Z.forEach(p),k=y(a),i=b(a,"TD",{});var K=T(i);l=w(K,e),K.forEach(p),r=y(a),m=b(a,"TD",{});var Q=T(m);S=w(Q,C),Q.forEach(p),A=y(a),O=b(a,"TD",{});var W=T(O);H=w(W,L),W.forEach(p),$=y(a),M=b(a,"TD",{});var X=T(M);P=w(X,N),X.forEach(p),G=y(a),U=b(a,"TD",{});var x=T(U);E.l(x),x.forEach(p),J=y(a),a.forEach(p)},m(u,a){I(u,t,a),c(t,h),c(h,s),c(t,f),c(t,d),c(d,v),c(t,k),c(t,i),c(i,l),c(t,r),c(t,m),c(m,S),c(t,A),c(t,O),c(O,H),c(t,$),c(t,M),c(M,P),c(t,G),c(t,U),E.m(U,null),c(t,J)},p(u,a){a&1&&n!==(n=u[2].beschreibung+"")&&B(s,n),a&1&&_!==(_=u[2].material+"")&&B(v,_),a&1&&e!==(e=u[2].preis+"")&&B(l,e),a&1&&C!==(C=u[2].inhaltsmenge+"")&&B(S,C),a&1&&L!==(L=u[2].state+"")&&B(H,L),a&1&&N!==(N=u[2].id+"")&&B(P,N),q===(q=V(u))&&E?E.p(u,a):(E.d(1),E=q(u),E&&(E.c(),E.m(U,null)))},d(u){u&&p(t),E.d()}}}function _t(o){let t,h="Alle Urnen",n,s,f,d='<tr><th scope="col">Beschreibung</th> <th scope="col">Material</th> <th scope="col">Preis</th> <th scope="col">Inhaltsmenge</th> <th scope="col">State</th> <th scope="col">UrneId</th> <th scope="col">Aktion</th></tr>',_,v,k=et(o[0]),i=[];for(let e=0;e<k.length;e+=1)i[e]=lt(nt(o,k,e));return{c(){t=g("h1"),t.textContent=h,n=D(),s=g("table"),f=g("thead"),f.innerHTML=d,_=D(),v=g("tbody");for(let e=0;e<i.length;e+=1)i[e].c();this.h()},l(e){t=b(e,"H1",{"data-svelte-h":!0}),R(t)!=="svelte-1kptfke"&&(t.textContent=h),n=y(e),s=b(e,"TABLE",{class:!0});var l=T(s);f=b(l,"THEAD",{"data-svelte-h":!0}),R(f)!=="svelte-crhq9p"&&(f.innerHTML=d),_=y(l),v=b(l,"TBODY",{});var r=T(v);for(let m=0;m<i.length;m+=1)i[m].l(r);r.forEach(p),l.forEach(p),this.h()},h(){at(s,"class","table")},m(e,l){I(e,t,l),I(e,n,l),I(e,s,l),c(s,f),c(s,_),c(s,v);for(let r=0;r<i.length;r+=1)i[r]&&i[r].m(v,null)},p(e,[l]){if(l&3){k=et(e[0]);let r;for(r=0;r<k.length;r+=1){const m=nt(e,k,r);i[r]?i[r].p(m,l):(i[r]=lt(m),i[r].c(),i[r].m(v,null))}for(;r<i.length;r+=1)i[r].d(1);i.length=k.length}},i:F,o:F,d(e){e&&(p(t),p(n),p(s)),ct(i,e)}}}function mt(o){try{const h=o.split(".")[1].replace(/-/g,"+").replace(/_/g,"/"),n=decodeURIComponent(atob(h).split("").map(function(s){return"%"+("00"+s.charCodeAt(0).toString(16)).slice(-2)}).join(""));return JSON.parse(n)}catch{return null}}function gt(o,t,h){let n,s;tt(o,ut,e=>h(4,n=e)),tt(o,dt,e=>h(5,s=e));const f=s.url.origin;let d=[],_={beschreibung:"",material:"",preis:0,inhaltsmenge:0};ot(()=>{v()});function v(){var e={method:"get",url:f+"/api/urne",headers:{},headers:{Authorization:"Bearer "+n}};z(e).then(function(l){h(0,d=l.data)}).catch(function(l){alert("Could not get Urnen"),console.log(l)})}async function k(e){try{const l={headers:{Authorization:"Bearer "+n}},m=mt(n).email;let C=await z.get(`${f}/api/order/byEmailAndStatus`,{params:{email:m,status:"ASSIGNED"},...l}),S=C.data;if(S.length>0){let A=S[0];A.urneIds.push(e),C=await z.post(`${f}/api/service/${A.id}/addUrne/${e}`,{},l)}else{const A={urneIds:[e]};C=await z.post(`${f}/api/order`,A,l)}alert("Urne successfully assigned to the order")}catch(l){alert("Failed to assign Urne to the order"),console.error(l)}}return[d,k,_,e=>k(e.id)]}class Dt extends st{constructor(t){super(),it(this,t,gt,_t,rt,{})}}export{Dt as component};
