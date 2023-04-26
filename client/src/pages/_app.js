import '@/styles/globals.scss'
import Head from 'next/head'
import Header from "@/components/Header"
import Container from 'react-bootstrap/Container'

export default function App({ Component, pageProps }) {
  return (
    <>
      <Head>
        <title>Ifood Clone</title>
        <link ref="icon" href="/favicon.icon" />
      </Head>

      <main>
        <Header />
        <Container className='mt-6'>
          <Component {...pageProps} />
        </Container>
      </main>
    </>
  )
}
