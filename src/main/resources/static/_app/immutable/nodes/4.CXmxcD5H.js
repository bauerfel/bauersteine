import{s as Z,n as q,c as w,o as x}from"../chunks/scheduler.sluXByI4.js";import{S as $,i as ee,e as D,s as U,c as T,l as L,f as B,a as y,d as k,m as C,g as A,h as p,q as W,k as G,t as N,b as O,j as V,r as te,o as X}from"../chunks/index.BQQS3HTZ.js";import{e as j}from"../chunks/each.D6YF6ztN.js";import{j as le,m as ne,a as z}from"../chunks/store.C8kMcS5N.js";import{p as re}from"../chunks/stores.PAL8E2NE.js";function P(r,e,l){const t=r.slice();return t[4]=e[l],t}function F(r,e,l){const t=r.slice();return t[13]=e[l],t}function R(r){let e,l,t=r[4].id+"",d,g,o,h=r[4].state+"",b,E,a,s,v,i,c=j(r[4].urneIds),f=[];for(let n=0;n<c.length;n+=1)f[n]=J(F(r,c,n));let m=r[4].state==="ASSIGNED"&&K(r);return{c(){e=D("tr"),l=D("td"),d=N(t),g=U(),o=D("td"),b=N(h),E=U(),a=D("td");for(let n=0;n<f.length;n+=1)f[n].c();s=U(),v=D("td"),m&&m.c(),i=U()},l(n){e=T(n,"TR",{});var _=y(e);l=T(_,"TD",{});var u=y(l);d=O(u,t),u.forEach(k),g=B(_),o=T(_,"TD",{});var I=y(o);b=O(I,h),I.forEach(k),E=B(_),a=T(_,"TD",{});var M=y(a);for(let H=0;H<f.length;H+=1)f[H].l(M);M.forEach(k),s=B(_),v=T(_,"TD",{});var S=y(v);m&&m.l(S),S.forEach(k),i=B(_),_.forEach(k)},m(n,_){A(n,e,_),p(e,l),p(l,d),p(e,g),p(e,o),p(o,b),p(e,E),p(e,a);for(let u=0;u<f.length;u+=1)f[u]&&f[u].m(a,null);p(e,s),p(e,v),m&&m.m(v,null),p(e,i)},p(n,_){if(_&1&&t!==(t=n[4].id+"")&&V(d,t),_&1&&h!==(h=n[4].state+"")&&V(b,h),_&9){c=j(n[4].urneIds);let u;for(u=0;u<c.length;u+=1){const I=F(n,c,u);f[u]?f[u].p(I,_):(f[u]=J(I),f[u].c(),f[u].m(a,null))}for(;u<f.length;u+=1)f[u].d(1);f.length=c.length}n[4].state==="ASSIGNED"?m?m.p(n,_):(m=K(n),m.c(),m.m(v,null)):m&&(m.d(1),m=null)},d(n){n&&k(e),W(f,n),m&&m.d()}}}function Y(r){let e,l="Entfernen",t,d;function g(){return r[5](r[4],r[13])}return{c(){e=D("button"),e.textContent=l,this.h()},l(o){e=T(o,"BUTTON",{class:!0,"data-svelte-h":!0}),L(e)!=="svelte-wtqoop"&&(e.textContent=l),this.h()},h(){C(e,"class","btn btn-danger")},m(o,h){A(o,e,h),t||(d=X(e,"click",g),t=!0)},p(o,h){r=o},d(o){o&&k(e),t=!1,d()}}}function J(r){let e,l,t,d='<img src="/images/Urne.jpeg" class="img-fluid rounded-start" alt="Urne Image"/>',g,o,h,b,E,a=r[13]+"",s,v,i,c="",f,m,n=r[4].state==="ASSIGNED"&&Y(r);return{c(){e=D("div"),l=D("div"),t=D("div"),t.innerHTML=d,g=U(),o=D("div"),h=D("div"),b=D("h5"),E=N("Urne ID: "),s=N(a),v=U(),i=D("p"),i.innerHTML=c,f=U(),n&&n.c(),m=U(),this.h()},l(_){e=T(_,"DIV",{class:!0,style:!0});var u=y(e);l=T(u,"DIV",{class:!0});var I=y(l);t=T(I,"DIV",{class:!0,"data-svelte-h":!0}),L(t)!=="svelte-1o024hd"&&(t.innerHTML=d),g=B(I),o=T(I,"DIV",{class:!0});var M=y(o);h=T(M,"DIV",{class:!0});var S=y(h);b=T(S,"H5",{class:!0});var H=y(b);E=O(H,"Urne ID: "),s=O(H,a),H.forEach(k),v=B(S),i=T(S,"P",{class:!0,"data-svelte-h":!0}),L(i)!=="svelte-1q59s4r"&&(i.innerHTML=c),f=B(S),n&&n.l(S),S.forEach(k),M.forEach(k),I.forEach(k),m=B(u),u.forEach(k),this.h()},h(){C(t,"class","col-md-4"),C(b,"class","card-title"),C(i,"class","card-text"),C(h,"class","card-body"),C(o,"class","col-md-8"),C(l,"class","row g-0"),C(e,"class","card mb-3"),te(e,"max-width","540px")},m(_,u){A(_,e,u),p(e,l),p(l,t),p(l,g),p(l,o),p(o,h),p(h,b),p(b,E),p(b,s),p(h,v),p(h,i),p(h,f),n&&n.m(h,null),p(e,m)},p(_,u){u&1&&a!==(a=_[13]+"")&&V(s,a),_[4].state==="ASSIGNED"?n?n.p(_,u):(n=Y(_),n.c(),n.m(h,null)):n&&(n.d(1),n=null)},d(_){_&&k(e),n&&n.d()}}}function K(r){let e,l="Bezahlen",t,d;function g(){return r[6](r[4])}return{c(){e=D("button"),e.textContent=l,this.h()},l(o){e=T(o,"BUTTON",{type:!0,class:!0,"data-svelte-h":!0}),L(e)!=="svelte-80x1e2"&&(e.textContent=l),this.h()},h(){C(e,"type","button"),C(e,"class","btn btn-secondary")},m(o,h){A(o,e,h),t||(d=X(e,"click",g),t=!0)},p(o,h){r=o},d(o){o&&k(e),t=!1,d()}}}function Q(r){let e,l=r[4].userEmail===r[1]&&R(r);return{c(){l&&l.c(),e=G()},l(t){l&&l.l(t),e=G()},m(t,d){l&&l.m(t,d),A(t,e,d)},p(t,d){t[4].userEmail===t[1]?l?l.p(t,d):(l=R(t),l.c(),l.m(e.parentNode,e)):l&&(l.d(1),l=null)},d(t){t&&k(e),l&&l.d(t)}}}function oe(r){let e,l="Deine Bestellungen",t,d,g,o='<tr><th scope="col">Bestellungnummer</th> <th scope="col">State</th> <th scope="col">UrneIds</th> <th scope="col">Bezahlen</th></tr>',h,b,E=j(r[0]),a=[];for(let s=0;s<E.length;s+=1)a[s]=Q(P(r,E,s));return{c(){e=D("h1"),e.textContent=l,t=U(),d=D("table"),g=D("thead"),g.innerHTML=o,h=U(),b=D("tbody");for(let s=0;s<a.length;s+=1)a[s].c();this.h()},l(s){e=T(s,"H1",{"data-svelte-h":!0}),L(e)!=="svelte-1y38g11"&&(e.textContent=l),t=B(s),d=T(s,"TABLE",{class:!0});var v=y(d);g=T(v,"THEAD",{"data-svelte-h":!0}),L(g)!=="svelte-7n66is"&&(g.innerHTML=o),h=B(v),b=T(v,"TBODY",{});var i=y(b);for(let c=0;c<a.length;c+=1)a[c].l(i);i.forEach(k),v.forEach(k),this.h()},h(){C(d,"class","table")},m(s,v){A(s,e,v),A(s,t,v),A(s,d,v),p(d,g),p(d,h),p(d,b);for(let i=0;i<a.length;i+=1)a[i]&&a[i].m(b,null)},p(s,[v]){if(v&15){E=j(s[0]);let i;for(i=0;i<E.length;i+=1){const c=P(s,E,i);a[i]?a[i].p(c,v):(a[i]=Q(c),a[i].c(),a[i].m(b,null))}for(;i<a.length;i+=1)a[i].d(1);a.length=E.length}},i:q,o:q,d(s){s&&(k(e),k(t),k(d)),W(a,s)}}}function se(r,e,l){let t,d,g;w(r,le,c=>l(7,t=c)),w(r,re,c=>l(8,d=c)),w(r,ne,c=>l(1,g=c));const o=d.url.origin;let h=[],b={id:"",urneIds:[],state:""};x(()=>{E()});function E(){var c={method:"get",url:o+"/api/order",headers:{},headers:{Authorization:"Bearer "+t}};z(c).then(function(f){l(0,h=f.data)}).catch(function(f){alert("Could not get orders"),console.log(f)})}function a(c){var f={method:"post",url:o+`/api/service/${c}/pay`,headers:{Authorization:"Bearer "+t}};z(f).then(function(m){alert("Order paid"),E()}).catch(function(m){alert("Could not pay order"),console.log(m)})}function s(c,f){var m={method:"delete",url:o+`/api/service/${c}/removeUrne/${f}`,headers:{Authorization:"Bearer "+t}};z(m).then(function(n){alert("Urne removed from order"),E()}).catch(function(n){alert("Could not remove Urne from order"),console.log(n)})}return[h,g,a,s,b,(c,f)=>s(c.id,f),c=>a(c.id)]}class he extends ${constructor(e){super(),ee(this,e,se,oe,Z,{})}}export{he as component};