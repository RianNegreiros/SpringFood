import { Row, Col, Card } from 'react-bootstrap'
import Image from 'next/legacy/image'

export default function Success() {
  return(
    <Row className='mt-4 justify-content-md-center'>
      <Col md={4}>
        <Card className='mt-4 p-4'>
          <h4 className='fw-bold'>Order on the way</h4>
          <p className='mt-2'>Your order will be delivered soon</p>

          <Row className='mt-y justify-content-md-center'>
            <Col md={10}>
              <Image
                src='/status-ok.png'
                alt='Order success'
                width={100}
                height={100}
                layout='responsive'
              />
            </Col>
          </Row>
        </Card>
      </Col>
    </Row>
  )
}