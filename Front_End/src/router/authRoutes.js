// 인증 관련 라우트 (로그인, 회원가입 등)
import UserLogin from '@/views/Auth/UserLogin.vue';
import Find_IDPW from '@/views/Auth/Find_IDPW.vue';

export default [
  {
    path: '/login',
    name: 'UserLogin',
    component: UserLogin,
  },
  {
    path: '/admin-login',
    name: 'AdminLogin',
    component: () => import('@/views/Auth/AdminLogin.vue'),
  },
  {
    path: '/signup',
    name: 'Signup',
    component: () => import('@/views/Auth/Signup.vue'),
  },
  {
    path: '/findIdPw',
    name: 'Find_IDPW',
    component: Find_IDPW,
  },
];
