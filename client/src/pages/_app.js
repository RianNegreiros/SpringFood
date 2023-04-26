import '@/styles/globals.scss'
import Head from 'next/head'
import Header from "@/components/Header"
import Container from 'react-bootstrap/Container'
import { RecoilRoot } from 'recoil'

export default function App({ Component, pageProps }) {
  return (
    <>
      <Head>
        <title>IFood Clone</title>
        <link ref="icon" href="/favicon.icon" />
      </Head>

      <main>
        <RecoilRoot>
          <Header />
          <Container className='mt-6'>
            <Component {...pageProps} />
          </Container>
        </RecoilRoot>
      </main>
    </>
  )
}
