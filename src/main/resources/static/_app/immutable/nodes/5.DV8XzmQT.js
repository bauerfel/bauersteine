import{s as rt,n as V,c as et,o as st}from"../chunks/scheduler.sluXByI4.js";import{S as ot,i as it,e as g,s as C,c as b,l as R,f as D,a as T,d as p,m as $,g as I,h as c,q as ct,t as j,b as w,j as B,o as ht}from"../chunks/index.Vlo5ODvd.js";import{e as nt}from"../chunks/each.D6YF6ztN.js";import{j as dt,a as z}from"../chunks/store.C8kMcS5N.js";import{p as ut}from"../chunks/stores.C-G4TRTc.js";function at(s,t,h){const n=s.slice();return n[2]=t[h],n}function ft(s){let t,h="Zu Bestellung hinzufügen",n,o;function f(){return s[3](s[2])}return{c(){t=g("button"),t.textContent=h,this.h()},l(d){t=b(d,"BUTTON",{type:!0,class:!0,"data-svelte-h":!0}),R(t)!=="svelte-ybc3sb"&&(t.textContent=h),this.h()},h(){$(t,"type","button"),$(t,"class","btn btn-secondary")},m(d,_){I(d,t,_),n||(o=ht(t,"click",f),n=!0)},p(d,_){s=d},d(d){d&&p(t),n=!1,o()}}}function pt(s){let t,h="Ausverkauft";return{c(){t=g("span"),t.textContent=h,this.h()},l(n){t=b(n,"SPAN",{class:!0,"data-svelte-h":!0}),R(t)!=="svelte-844lc3"&&(t.textContent=h),this.h()},h(){$(t,"class","badge bg-secondary")},m(n,o){I(n,t,o)},p:V,d(n){n&&p(t)}}}function lt(s){let t,h,n=s[2].beschreibung+"",o,f,d,_=s[2].material+"",v,k,i,e=s[2].preis+"",a,r,m,y=s[2].inhaltsmenge+"",S,A,O,L=s[2].state+"",H,G,M,N=s[2].id+"",P,J,U,F;function Y(u,l){return u[2].state==="ASSIGNED"||u[2].state==="SOLD"||u[2].state==="DELIVERED"?pt:ft}let q=Y(s),E=q(s);return{c(){t=g("tr"),h=g("td"),o=j(n),f=C(),d=g("td"),v=j(_),k=C(),i=g("td"),a=j(e),r=C(),m=g("td"),S=j(y),A=C(),O=g("td"),H=j(L),G=C(),M=g("td"),P=j(N),J=C(),U=g("td"),E.c(),F=C()},l(u){t=b(u,"TR",{});var l=T(t);h=b(l,"TD",{});var Z=T(h);o=w(Z,n),Z.forEach(p),f=D(l),d=b(l,"TD",{});var K=T(d);v=w(K,_),K.forEach(p),k=D(l),i=b(l,"TD",{});var Q=T(i);a=w(Q,e),Q.forEach(p),r=D(l),m=b(l,"TD",{});var W=T(m);S=w(W,y),W.forEach(p),A=D(l),O=b(l,"TD",{});var X=T(O);H=w(X,L),X.forEach(p),G=D(l),M=b(l,"TD",{});var x=T(M);P=w(x,N),x.forEach(p),J=D(l),U=b(l,"TD",{});var tt=T(U);E.l(tt),tt.forEach(p),F=D(l),l.forEach(p)},m(u,l){I(u,t,l),c(t,h),c(h,o),c(t,f),c(t,d),c(d,v),c(t,k),c(t,i),c(i,a),c(t,r),c(t,m),c(m,S),c(t,A),c(t,O),c(O,H),c(t,G),c(t,M),c(M,P),c(t,J),c(t,U),E.m(U,null),c(t,F)},p(u,l){l&1&&n!==(n=u[2].beschreibung+"")&&B(o,n),l&1&&_!==(_=u[2].material+"")&&B(v,_),l&1&&e!==(e=u[2].preis+"")&&B(a,e),l&1&&y!==(y=u[2].inhaltsmenge+"")&&B(S,y),l&1&&L!==(L=u[2].state+"")&&B(H,L),l&1&&N!==(N=u[2].id+"")&&B(P,N),q===(q=Y(u))&&E?E.p(u,l):(E.d(1),E=q(u),E&&(E.c(),E.m(U,null)))},d(u){u&&p(t),E.d()}}}function _t(s){let t,h="Alle Urnen",n,o,f,d='<tr><th scope="col">Beschreibung</th> <th scope="col">Material</th> <th scope="col">Preis</th> <th scope="col">Inhaltsmenge</th> <th scope="col">State</th> <th scope="col">UrneId</th> <th scope="col">Aktion</th></tr>',_,v,k=nt(s[0]),i=[];for(let e=0;e<k.length;e+=1)i[e]=lt(at(s,k,e));return{c(){t=g("h1"),t.textContent=h,n=C(),o=g("table"),f=g("thead"),f.innerHTML=d,_=C(),v=g("tbody");for(let e=0;e<i.length;e+=1)i[e].c();this.h()},l(e){t=b(e,"H1",{"data-svelte-h":!0}),R(t)!=="svelte-1kptfke"&&(t.textContent=h),n=D(e),o=b(e,"TABLE",{class:!0});var a=T(o);f=b(a,"THEAD",{"data-svelte-h":!0}),R(f)!=="svelte-crhq9p"&&(f.innerHTML=d),_=D(a),v=b(a,"TBODY",{});var r=T(v);for(let m=0;m<i.length;m+=1)i[m].l(r);r.forEach(p),a.forEach(p),this.h()},h(){$(o,"class","table")},m(e,a){I(e,t,a),I(e,n,a),I(e,o,a),c(o,f),c(o,_),c(o,v);for(let r=0;r<i.length;r+=1)i[r]&&i[r].m(v,null)},p(e,[a]){if(a&3){k=nt(e[0]);let r;for(r=0;r<k.length;r+=1){const m=at(e,k,r);i[r]?i[r].p(m,a):(i[r]=lt(m),i[r].c(),i[r].m(v,null))}for(;r<i.length;r+=1)i[r].d(1);i.length=k.length}},i:V,o:V,d(e){e&&(p(t),p(n),p(o)),ct(i,e)}}}function mt(s){try{const h=s.split(".")[1].replace(/-/g,"+").replace(/_/g,"/"),n=decodeURIComponent(atob(h).split("").map(function(o){return"%"+("00"+o.charCodeAt(0).toString(16)).slice(-2)}).join(""));return JSON.parse(n)}catch{return null}}function gt(s,t,h){let n,o;et(s,dt,e=>h(4,n=e)),et(s,ut,e=>h(5,o=e));const f=o.url.origin;let d=[],_={beschreibung:"",material:"",preis:0,inhaltsmenge:0};st(()=>{v()});function v(){var e={method:"get",url:f+"/api/urne",headers:{},headers:{Authorization:"Bearer "+n}};z(e).then(function(a){h(0,d=a.data)}).catch(function(a){alert("Could not get Urnen"),console.log(a)})}async function k(e){try{const a={headers:{Authorization:"Bearer "+n}},m=mt(n).email;let y=await z.get(`${f}/api/order/byEmailAndStatus`,{params:{email:m,status:"ASSIGNED"},...a}),S=y.data;if(S.length>0){let A=S[0];A.urneIds.push(e),y=await z.post(`${f}/api/service/${A.id}/addUrne/${e}`,{},a)}else{const A={urneIds:[e]};y=await z.post(`${f}/api/order`,A,a)}alert("Urne successfully assigned to the order")}catch(a){alert("Failed to assign Urne to the order"),console.error(a)}}return[d,k,_,e=>k(e.id)]}class yt extends ot{constructor(t){super(),it(this,t,gt,_t,rt,{})}}export{yt as component};
