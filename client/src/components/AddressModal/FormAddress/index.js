import { useState } from 'react'
import { Row, Col, Button, Form, Spinner, Alert } from 'react-bootstrap'
import { useRouter } from 'next/router'

import { useRecoilState } from 'recoil'
import addressState from '@/store/atoms/addressAtom'

import getAvailableCities from '@/services/getAvailableCities'


export default function FormAddress(props) {
  const { available_cities, isLoading, isError } = getAvailableCities()
  const [address, setAddress] = useRecoilState(addressState)
  const [cityChanged, setCityChanged] = useState(false)
  const router = useRouter()

  if (isError)
    return <Alert variant='custom-red'>Error loading</Alert>
  else if (isLoading)
    return <Spinner animation='border' />


  const updateAddress = (e) => {
    if (e.target.name == 'city')
      setCityChanged(true)
    setAddress({ ...address, [e.target.name]: e.target.value })
  }

  const confirmAddress = (e) => {
    e.preventDefault()
    props.onHide()
    if (cityChanged)
      router.push('/restaurants')
  }

  return (
    <Row>
      <Col md={12}>
        <Form onSubmit={e => confirmAddress(e)}>
          <Form.Group>
            <Form.Label>City</Form.Label>
            <Form.Control
              required 
              as="select"
              onChange={updateAddress}
              value={address.city}
              name="city"
            >
              {address.city == '' && <option key={0}>Choose city</option>}
              {available_cities.map((city, i) => (<option key={i} value={city}>{city}</option>))}
            </Form.Control>
          </Form.Group>
          {address.city != '' &&
            <div>
              <Form.Group className='mt-3'>
                <Form.Label>Neighborhood</Form.Label>
                <Form.Control
                  required
                  type="text"
                  placeholder="Neighborhood"
                  onChange={updateAddress}
                  value={address.neighborhood}
                  name="neighborhood"
                />
              </Form.Group>
              <Form.Group className='mt-3'>
                <Form.Label>Street</Form.Label>
                <Form.Control
                  required
                  type="text"
                  placeholder="Street"
                  onChange={updateAddress}
                  value={address.street}
                  name="street"
                />
              </Form.Group>
              <Form.Group className='mt-3'>
                <Form.Label>Number</Form.Label>
                <Form.Control
                  required
                  type="text"
                  placeholder="Number"
                  onChange={updateAddress}
                  value={address.number}
                  name="number"
                />
              </Form.Group>
              <Form.Group className='mt-3'>
                <Form.Label>Complement</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Complement"
                  onChange={updateAddress}
                  value={address.complement}
                  name="complement"
                />
              </Form.Group>
              <div className="text-center pt-4">
                <Button variant="custom-red" className='text-white' type="submit" size="md">
                  Confirm address
              </Button>
              </div>
            </div>
          }
        </Form>
      </Col>
    </Row>
  )

}
